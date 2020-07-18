package com.kimzing.utils.security;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Base64测试.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/18 12:42
 */
public class BASE64UtilTest {


    @Test
    public void encodeTest() {
        String encode = BASE64Util.encodeToString("你好啊helloword".getBytes());
        System.out.println(encode);
    }


    @Test
    public void decodeTest() throws UnsupportedEncodingException {
        byte[] bytes = BASE64Util.decodeFromString("5L2g5aW95ZWKaGVsbG93b3Jk");
        System.out.println(new String(bytes, "utf-8"));
    }

}
