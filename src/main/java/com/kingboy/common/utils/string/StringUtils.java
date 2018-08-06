package com.kingboy.common.utils.string;

/**
 * 字符串工具类.
 * @author KingBoy - KingBoyWorld@163.com
 * @since 2018-08-07
 */
public class StringUtils {

    /**
     * 是否为空.
     * "" => true;
     * " " => true
     * "a"  false
     * @param cs
     * @return
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static boolean isBlank(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isBlank(cs);
    }

    /**
     * 是否为空.
     * ""    true
     * "  "  false
     * "a"   false
     * @param cs
     * @return
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static boolean isEmpty(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isEmpty(cs);
    }

    /**
     * 去除空格
     * null   null
     * "a  "  "a"
     * "  a"  "a"
     * @param s
     * @return
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static String trim(String s) {
     return org.apache.commons.lang3.StringUtils.trim(s);
    }

}
