package com.kingboy.common.utils.string;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/12/27 下午12:40
 * @desc 字符串工具类.
 */
public class StringUtils {

    /**
     * ""   true
     * " "  true
     * "a"  false
     * @param cs
     * @return
     */
    public static boolean isBlank(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isBlank(cs);
    }

    /**
     * ""    true
     * "  "  false
     * "a"   false
     * @param cs
     * @return
     */
    public static boolean isEmpty(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isEmpty(cs);
    }

    /**
     * null   null
     * "a  "  "a"
     * "  a"  "a"
     * @param s
     * @return
     */
    public static String trim(String s) {
     return org.apache.commons.lang3.StringUtils.trim(s);
    }

}
