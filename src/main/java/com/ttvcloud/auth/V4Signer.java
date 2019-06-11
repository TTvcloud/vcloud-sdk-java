package com.ttvcloud.auth;

import com.ttvcloud.model.Credentials;
import com.ttvcloud.model.SignableRequest;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.util.EntityUtils;


import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.ttvcloud.util.Const.TimeFormatV4;

public class V4Signer extends AbstractSigner{


    private static final TimeZone tz = TimeZone.getTimeZone("UTC");


    public void sign(SignableRequest request, Credentials credentials) throws Exception {

        sign4(request, credentials);
        request.setURI(request.getUriBuilder().build());
    }

    public String signUrl(SignableRequest request, Credentials credentials) throws Exception {

        String ldt = timestampV4();
        String sdt = ldt.substring(0,8);
        MedaData meta = new MedaData();
        meta.setDate(sdt);
        meta.setService(credentials.getService());
        meta.setRegion(credentials.getRegion());
        meta.setSignedHeaders("");
        meta.setAlgorithm("AWS4-HMAC-SHA256");
        meta.setCredentialScope(concat("/", meta.getDate(), meta.getRegion(), meta.getService(), "aws4_request"));

        URIBuilder builder = request.getUriBuilder();
        builder.setParameter("X-Amz-Date", ldt);
        builder.setParameter("X-Amz-NotSignBody", "");
        builder.setParameter("X-Amz-Credential", credentials.getAccessKeyID()+"/"+meta.getCredentialScope());
        builder.setParameter("X-Amz-Algorithm", meta.getAlgorithm());
        builder.setParameter("X-Amz-SignedHeaders", meta.getSignedHeaders());
        builder.setParameter("X-Amz-SignedQueries", "");
        List<String> keys = new ArrayList<String>();
        for (NameValuePair pair : builder.getQueryParams()) {
            keys.add(pair.getName());
        }
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        builder.setParameter("X-Amz-SignedQueries", StringUtils.join(keys, ";"));

        // Task 1
        String hashedCanonReq = hashedSimpleCanonicalRequestV4(request, meta);

        // Task 2
        String stringToSign = concat("\n", meta.getAlgorithm(), ldt, meta.getCredentialScope(), hashedCanonReq);

        // Task 3
        byte[] signingKey = signingKeyV4(credentials.getSecretAccessKey(), meta.getDate(), meta.getRegion(), meta.getService());
        String signature = signatureV4(signingKey, stringToSign);

        builder.setParameter("X-Amz-Signature", signature);

        List<NameValuePair> params = builder.getQueryParams();
        Collections.sort(params, new Comparator<NameValuePair>() {
            @Override
            public int compare(NameValuePair o1, NameValuePair o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        builder.clearParameters();
        builder.setParameters(params);
        return builder.build().toURL().getQuery();
    }

    private void sign4(SignableRequest request, Credentials credentials) throws Exception {

        prepareRequestV4(request);
        MedaData meta = new MedaData();
        meta.setService(credentials.getService());
        meta.setRegion(credentials.getRegion());

        // Task 1
        String hashedCanonReq = hashedCanonicalRequestV4(request, meta);

        // Task 2
        String stringToSign = stringToSignV4(request, hashedCanonReq, meta);

        // Task 3
        byte[] signingKey = signingKeyV4(credentials.getSecretAccessKey(), meta.getDate(), meta.getRegion(),
                meta.getService());
        String signature = signatureV4(signingKey, stringToSign);

        request.setHeader("Authorization", buildAuthHeaderV4(signature, meta, credentials));
    }

    private String hashedSimpleCanonicalRequestV4(SignableRequest request, MedaData meta) throws Exception {
        String payloadHash = hashSHA256(new byte[0]);

        URIBuilder builder = request.getUriBuilder();
        if (builder.getPath().equals("")) {
            builder.setPath("/");
        }

        String canonicalRequest = concat("\n", request.getMethod(), normuri(builder.getPath()),
                normquery(builder.getQueryParams()), "\n", meta.getSignedHeaders(), payloadHash);

        return hashSHA256(canonicalRequest.getBytes());
    }

    private String hashedCanonicalRequestV4(SignableRequest request, MedaData meta) throws Exception {
        byte[] payload = readBody(request);
        String payloadHash = hashSHA256(payload);
        request.setHeader("X-Amz-Content-Sha256", payloadHash);

        request.setHeader("Host", request.getUriBuilder().getHost());

        List<String> headers = new ArrayList<String>();

        for (Header header : request.getAllHeaders()) {
            String h = header.getName();
            if (H_INCLUDE.contains(h) || h.startsWith("X-Amz-")) {
                headers.add(h.toLowerCase());
            }
        }
        Collections.sort(headers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        StringBuilder headersToSign = new StringBuilder();
        for (String h : headers) {
            String value = request.getFirstHeader(h).getValue().trim();
            if (h.equals("host")) {
                if (value.contains(":")) {
                    String[] split = value.split(":");
                    String port = split[1];
                    if (port.equals("80") || port.equals("443")) {
                        value = split[0];
                    }
                }
            }
            headersToSign.append(h).append(":").append(value).append("\n");
        }

        meta.setSignedHeaders(StringUtils.join(headers, ";"));

        String canonicalRequest = concat("\n", request.getMethod(), normuri(request.getUriBuilder().getPath()),
                normquery(request.getUriBuilder().getQueryParams()), headersToSign.toString(),
                        meta.getSignedHeaders(), payloadHash);

        return hashSHA256(canonicalRequest.getBytes());
    }

    private String stringToSignV4(SignableRequest request, String hashedCanonReq, MedaData meta) {

        String requestTs = request.getFirstHeader("X-Amz-Date").getValue();
        meta.setAlgorithm("AWS4-HMAC-SHA256");

        meta.setDate(tsDateV4(requestTs));
        meta.setCredentialScope(concat("/", meta.getDate(), meta.getRegion(), meta.getService(), "aws4_request"));

        return concat("\n", meta.getAlgorithm(), requestTs, meta.getCredentialScope(), hashedCanonReq);
    }

    private byte[] signingKeyV4(String secretKey, String date, String region, String service) throws Exception {
        byte[] kDate = hmacSHA256(("AWS4"+secretKey).getBytes(), date);
        byte[] kRegion = hmacSHA256(kDate, region);
        byte[] kService = hmacSHA256(kRegion, service);
        return hmacSHA256(kService, "aws4_request");
    }

    private String signatureV4(byte[] signingKey, String stringToSign) throws Exception {
        return Hex.encodeHexString(hmacSHA256(signingKey, stringToSign));
    }

    private String buildAuthHeaderV4(String signature, MedaData meta, Credentials credentials) {
        String credential = credentials.getAccessKeyID() + "/" + meta.getCredentialScope();

        return meta.getAlgorithm() +
                " Credential=" + credential +
                ", SignedHeaders=" + meta.getSignedHeaders() +
                ", Signature=" + signature;
    }


    private byte[] readBody(SignableRequest request) throws Exception {
         HttpEntity entity = request.getEntity();
         if (entity == null) {
             return new byte[0];
         }

         return EntityUtils.toByteArray(entity);
    }

    private void prepareRequestV4(SignableRequest request) {

        Map<String, String> necessaryDefaults = new HashMap<String, String>();
        necessaryDefaults.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        necessaryDefaults.put("X-Amz-Date", timestampV4());

        for (String header : necessaryDefaults.keySet()) {
            if (!request.containsHeader(header)) {
                request.setHeader(header, necessaryDefaults.get(header));
            }
        }
        URIBuilder builder = request.getUriBuilder();
        if (builder.getPath().equals("")) {
            builder.setPath(builder.getPath() + "/");
        }

    }

    private String concat(String delim, String... toJoin) {
        return StringUtils.join(toJoin, delim);
    }

    private String timestampV4() {
        DateFormat df = new SimpleDateFormat(TimeFormatV4);
        df.setTimeZone(tz);
        return df.format(new Date());
    }

    private String tsDateV4(String timestamp) {
        return timestamp.substring(0, 8);
    }

    private String normuri(String path) {
        return URLEncoder.encode(path).replace("%2F", "/").replace("+", "%20");
    }


    private String normquery(List<NameValuePair> params) {
        Collections.sort(params, new Comparator<NameValuePair>() {
            @Override
            public int compare(NameValuePair o1, NameValuePair o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        String query = URLEncodedUtils.format(params, Consts.UTF_8);
        return query.replace("+", "%20");
    }


    private static final Set<String> H_INCLUDE = new HashSet<String>();
    static {
        H_INCLUDE.add("Content-Type");
        H_INCLUDE.add("Content-Md5");
        H_INCLUDE.add("Host");
    }

}
