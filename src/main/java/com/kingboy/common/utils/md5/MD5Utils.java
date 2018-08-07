package com.kingboy.common.utils.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * MD5工具类, 全部接收UTF编码的String.
 * <p></p>
 *
 * @author KingBoy - KingBoyWorld@163.com
 * @since 2018-08-07 02:02
 */
public final class MD5Utils {

    /**
     * 算法
     */
    private static final String ALGORITHM_MD5 = "MD5";

    /**
     * 编码
     */
    private static final String UTF_8 = "UTF-8";

    /**
     * MD5 16bit 小写.
     * <p></p>
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     * @throws NoSuchAlgorithmException
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static String md5Bit16Lower(String readyEncryptStr) throws Exception {
        if (Objects.nonNull(readyEncryptStr)) {
            return MD5Utils.md5Bit32Lower(readyEncryptStr).substring(8, 24);
        } else {
            return null;
        }
    }

    /**
     * MD5 16bit 大写.
     * <p></p>
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     * @throws NoSuchAlgorithmException
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static String md5Bit16Upper(String readyEncryptStr) throws Exception {
        return md5Bit16Lower(readyEncryptStr).toUpperCase();
    }

    /**
     * MD5 32bit 小写.
     * <p></p>
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     * @throws NoSuchAlgorithmException
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static String md5Bit32Lower(String readyEncryptStr) throws Exception {
        if (Objects.nonNull(readyEncryptStr)) {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM_MD5);
            md.update(readyEncryptStr.getBytes(UTF_8));
            byte[] b = md.digest();
            StringBuilder su = new StringBuilder();
            for (int offset = 0, bLen = b.length; offset < bLen; offset++) {
                String haxHex = Integer.toHexString(b[offset] & 0xFF);
                if (haxHex.length() < 2) {
                    su.append("0");
                }
                su.append(haxHex);
            }
            return su.toString();
        } else {
            return null;
        }
    }

    /**
     * MD5 32bit 大写.
     * <p></p>
     * @param readyEncryptStr ready encrypt string
     * @return String encrypt result string
     * @throws NoSuchAlgorithmException
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static String md5Bit32Upper(String readyEncryptStr) throws Exception {
        return md5Bit32Lower(readyEncryptStr).toUpperCase();
    }

}
