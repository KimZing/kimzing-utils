package com.kimzing.utils.security;

import org.junit.Assert;
import org.junit.Test;

/**
 * Aes加解密测试.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/15 23:41
 */
public class AESUtilTest {

    /*
     * 加解密测试.
     */
    @Test
    public void test() {
        String content = "hello";
        String password = "123abc";
        String encrypt = AESUtil.encrypt(content, password);
        String decrypt = AESUtil.decrypt(encrypt, password);
        Assert.assertEquals(content, decrypt);
    }

}
