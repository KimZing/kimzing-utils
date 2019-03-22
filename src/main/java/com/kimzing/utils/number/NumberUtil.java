package com.kimzing.utils.number;

/**
 * 字节数组工具类.
 * <p>
 * 字节数组与int/short之间的转换, asc代表字节序
 * </p>
 *
 * @author KimZing - kimzing@163.com
 * @since 2019-03-09 10:22
 */
public class NumberUtil {

    /**
     * 将short转换为byte[]
     * @param s
     * @param asc
     * @return
     */
    public static final byte[] getBytes(short s, boolean asc) {
        byte[] buf = new byte[2];
        if (asc) {
            for (int i = buf.length - 1; i >= 0; i--) {
                buf[i] = (byte) (s & 0x00ff);
                s >>= 8;
            }
        } else {
            for (int i = 0; i < buf.length; i++) {
                buf[i] = (byte) (s & 0x00ff);
                s >>= 8;
            }
        }
        return buf;
    }

    /**
     * 将int转换为byte[]
     * @param s
     * @param asc
     * @return
     */
    public static final byte[] getBytes(int s, boolean asc) {
        byte[] buf = new byte[4];
        if (asc) {
            for (int i = buf.length - 1; i >= 0; i--) {
                buf[i] = (byte) (s & 0x000000ff);
                s >>= 8;
            }
        } else {
            for (int i = 0; i < buf.length; i++) {
                buf[i] = (byte) (s & 0x000000ff);
                s >>= 8;
            }
        }
        return buf;
    }


    /**
     * 将byte[]转换为short
     * @param buf
     * @param asc
     * @return
     */
    public static final short getShort(byte[] buf, boolean asc) {
        if (buf == null) {
            throw new IllegalArgumentException("byte array is null!");
        }
        if (buf.length > 2) {
            throw new IllegalArgumentException("byte array size > 2 !");
        }
        short r = 0;
        if (asc) {
            for (int i = buf.length - 1; i >= 0; i--) {
                r <<= 8;
                r |= (buf[i] & 0x00ff);
            }
        } else {
            for (int i = 0; i < buf.length; i++) {
                r <<= 8;
                r |= (buf[i] & 0x00ff);
            }
        }
        return r;
    }

    /**
     * 将byte[] 转换为int
     * @param buf
     * @param asc
     * @return
     */
    public static final int getInt(byte[] buf, boolean asc) {
        if (buf == null) {
            throw new IllegalArgumentException("byte array is null!");
        }
        if (buf.length > 4) {
            throw new IllegalArgumentException("byte array size > 4 !");
        }
        int r = 0;
        if (asc) {
            for (int i = buf.length - 1; i >= 0; i--) {
                r <<= 8;
                r |= (buf[i] & 0x000000ff);
            }
        } else {
            for (int i = 0; i < buf.length; i++) {
                r <<= 8;
                r |= (buf[i] & 0x000000ff);
            }
        }
        return r;
    }

}
