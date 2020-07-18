package com.kimzing.utils.security;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Base64工具
 *
 * @author KimZing - kimzing@163.com
 * @since 2020年07月15日23:55:51
 */
public abstract class BASE64Util {

    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;


    /**
     * 编码给定的字节数组
     *
     * @param src the original byte array
     * @return the encoded byte array
     */
    public static byte[] encode(byte[] src) {
        if (src.length == 0) {
            return src;
        }
        return Base64.getEncoder().encode(src);
    }

    /**
     * 解码给定的字节数组
     *
     * @param src the encoded byte array
     * @return the original byte array
     */
    public static byte[] decode(byte[] src) {
        if (src.length == 0) {
            return src;
        }
        return Base64.getDecoder().decode(src);
    }

    /**
     * 编码给定的字符串
     *
     * @param src the original byte array
     * @return the encoded byte array
     */
    public static String encode(String src) {
        if (src == null) {
            return null;
        }
        byte[] encode = encode(src.getBytes(DEFAULT_CHARSET));
        return new String(encode, DEFAULT_CHARSET);
    }

    /**
     * 解码给定的字节数组
     *
     * @param src the encoded byte array
     * @return the original byte array
     */
    public static String decode(String src) {
        if (src == null) {
            return null;
        }
        byte[] decode = decode(src.getBytes(DEFAULT_CHARSET));
        return new String(decode, DEFAULT_CHARSET);
    }

    /**
     * 将给定的字节数组编码为String
     *
     * @param src the original byte array
     * @return the encoded byte array as a UTF-8 String
     */
    public static String encodeToString(byte[] src) {
        if (src.length == 0) {
            return "";
        }
        return new String(encode(src), DEFAULT_CHARSET);
    }

    /**
     * 将给定的UTF8字符串解码为字节数组
     *
     * @param src the encoded UTF-8 String
     * @return the original byte array
     */
    public static byte[] decodeFromString(String src) {
        if (src.isEmpty()) {
            return new byte[0];
        }
        return decode(src.getBytes(DEFAULT_CHARSET));
    }

}