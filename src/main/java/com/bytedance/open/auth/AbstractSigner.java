package com.bytedance.open.auth;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

public abstract class AbstractSigner implements Signer {

    protected String hashSHA256(byte[] content) throws Exception {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return Hex.encodeHexString(md.digest(content));
        } catch (Exception e) {
            throw new Exception(
                    "Unable to compute hash while signing request: "
                            + e.getMessage(), e);
        }
    }

//    protected String hashSHA256(InputStream input) throws Exception {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            DigestInputStream digestInputStream = new DigestInputStream(input, md);
//            byte[] buffer = new byte[1024];
//            while (digestInputStream.read(buffer) > -1)
//                ;
//            byte[] res = digestInputStream.getMessageDigest().digest();
//            return Hex.encodeHexString(res);
//        } catch (Exception e) {
//            throw new Exception(
//                    "Unable to compute hash while signing request: "
//                            + e.getMessage(), e);
//        }
//    }

    protected byte[] hmacSHA256(byte[] key, String content) throws Exception {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(key, "HmacSHA256"));
            return mac.doFinal(content.getBytes());
        } catch (Exception e) {
            throw new Exception(
                    "Unable to calculate a request signature: "
                            + e.getMessage(), e);
        }
    }

}
