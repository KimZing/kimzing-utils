package com.kingboy.common.utils.string;

/**
 * 字符串工具类.
 * <p></p>
 *
 * @author KingBoy - KingBoyWorld@163.com
 * @since 2018-08-07 02:02
 */
public class StringUtils {

    /**
     * 是否为空.
     * <p>
     *     "" => true;
     *     " " => true
     *     "a"  false
     * </p>
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
     * <p>
     *     ""    true
     *     "  "  false
     *     "a"   false
     * </p>
     * @param cs
     * @return
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static boolean isEmpty(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isEmpty(cs);
    }

    /**
     * 去除空格.
     * <p>
     *     null   null
     *     "a  "  "a"
     *     "  a"  "a"
     * </p>
     * @param s
     * @return
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static String trim(String s) {
     return org.apache.commons.lang3.StringUtils.trim(s);
    }

}
