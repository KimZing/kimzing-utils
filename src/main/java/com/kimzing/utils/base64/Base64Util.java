package com.kimzing.utils.base64;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Base64工具
 *
 * @author KimZing - kimzing@163.com
 * @since 2020年07月15日23:55:51
 */
public abstract class Base64Util {

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