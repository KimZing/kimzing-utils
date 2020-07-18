package com.kimzing.utils.security;

import org.junit.Assert;
import org.junit.Test;

/**
 * sha摘要测试.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/18 13:06
 */
public class SHAUtilTest {

    @Test
    public void testSha1() {
        String result = SHAUtil.sha1("你好啊hello");
        System.out.println(result);
        Assert.assertEquals(result, "3a952f26c6063aa166f262f3705fad67a6afea40");
    }

    @Test
    public void testSha256() {
        String result = SHAUtil.sha256("你好啊hello");
        System.out.println(result);
        Assert.assertEquals(result, "c673fb0860b7b35ddeb6d65126c172121404236170d8673b855360e1adaa0643");
    }

}
