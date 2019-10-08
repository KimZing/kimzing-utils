package com.kimzing.utils.aes;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES 是一种可逆加密算法，对用户的敏感信息加密处理
 * 对原始数据进行AES加密后，在进行Base64编码转化；
 */
public final class AesCBC {

    private static AesCBC instance = null;

    private AesCBC() {

    }

    public static AesCBC getInstance() {
        if (instance == null) {
            instance = new AesCBC();
        }
        return instance;
    }

    /**
     * 加密.
     *
     * @param sSrc
     * @param encodingFormat
     * @param sKey
     * @param ivParameter
     * @return java.lang.String
     */
    public String encrypt(String sSrc, String encodingFormat, String sKey, String ivParameter) throws Exception {
        Cipher cipher = null;
        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = sKey.getBytes(encodingFormat);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        //使用CBC模式，需要一个向量iv，可增加加密算法的强度
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes(encodingFormat));
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(encodingFormat));
        //此处使用BASE64做转码。
        return new BASE64Encoder().encode(encrypted);
    }

    /**
     * 解密.
     *
     * @param sSrc
     * @param encodingFormat
     * @param sKey
     * @param ivParameter
     * @return java.lang.String
     */
    public String decrypt(String sSrc, String encodingFormat, String sKey, String ivParameter) throws Exception {
        byte[] raw = sKey.getBytes("ASCII");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes(encodingFormat));
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        //先用base64解密
        byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);
        byte[] original = cipher.doFinal(encrypted1);
        return new String(original, encodingFormat);
    }
}
