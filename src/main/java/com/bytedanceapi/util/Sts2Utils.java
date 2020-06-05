package com.bytedanceapi.util;

import com.alibaba.fastjson.JSON;
import com.bytedanceapi.model.Credentials;
import com.bytedanceapi.model.sts2.InnerToken;
import com.bytedanceapi.model.sts2.Policy;
import com.bytedanceapi.model.sts2.SecurityToken2;
import com.bytedanceapi.model.sts2.Statement;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.RandomStringUtils;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

public class Sts2Utils {
    public static String generateAccessKeyId(String prefix) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String uidBase64 = Base64.getEncoder().encodeToString(uuid.getBytes());
        return prefix + uidBase64.replace("=", "")
                .replace("/", "")
                .replace("+", "")
                .replace("-", "");
    }

    public static String generateSecretKey() throws Exception {
        String randString32 = RandomStringUtils.randomAlphabetic(32);
        return aesEncryptCBC(randString32, "bytedance-isgood".getBytes());
    }

    public static String aesEncryptCBC(String sSrc, byte[] sKey) throws Exception {
        if (sKey == null) {
            throw new RuntimeException("Key为空null");
        }
        if (sKey.length != 16) {
            throw new RuntimeException("Key长度不是16位");
        }
        SecretKeySpec skeySpec = new SecretKeySpec(sKey, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
        IvParameterSpec iv = new IvParameterSpec(sKey);//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    public static InnerToken createInnerToken(Credentials credentials, SecurityToken2 sts2, Policy inlinePolicy, long t) throws Exception {
        InnerToken innerToken = new InnerToken();
        innerToken.setLtAccessKeyId(credentials.getAccessKeyID());
        innerToken.setAccessKeyId(sts2.getAccessKeyId());
        innerToken.setExpiredTime(t);

        byte[] key = genMD5Checksum(credentials.getSecretAccessKey().getBytes());
        innerToken.setSignedSecretAccessKey(aesEncryptCBC(sts2.getSecretAccessKey(), key));

        innerToken.setPolicyString(JSON.toJSONString(inlinePolicy));

        String signStr = String.format("%s|%s|%d|%s|%s", innerToken.getLtAccessKeyId(), innerToken.getAccessKeyId(), innerToken.getExpiredTime(),
                innerToken.getSignedSecretAccessKey(), innerToken.getPolicyString());
        innerToken.setSignature(sha256Hex(key, signStr));
        return innerToken;
    }

    public static byte[] genMD5Checksum(byte[] content) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(content);
        return messageDigest.digest();
    }

    private static String sha256Hex(byte[] signingKey, String stringToSign) throws InvalidKeyException, NoSuchAlgorithmException {
        Charset UTF8 = Charset.forName("UTF-8");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(signingKey, "HmacSHA256"));
        return new String(Hex.encodeHex(mac.doFinal(stringToSign.getBytes(UTF8))));
    }

    public static Statement newAllowStatement(List<String> actions, List<String> resources) {
        Statement statement = new Statement();
        statement.setEffect("Allow");
        statement.setAction(actions);
        statement.setResource(resources);
        return statement;
    }

    public static Statement newDenyStatement(List<String> actions, List<String> resources) {
        Statement statement = new Statement();
        statement.setEffect("Deny");
        statement.setAction(actions);
        statement.setResource(resources);
        return statement;
    }
}
