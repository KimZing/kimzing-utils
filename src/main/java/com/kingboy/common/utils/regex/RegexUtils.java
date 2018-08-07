package com.kingboy.common.utils.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则.
 * <p></p>
 *
 * @author KingBoy - KingBoyWorld@163.com
 * @since 2018-08-07 02:02
 */
public final class RegexUtils {

    private static Pattern mobile = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");

    private static Pattern chinese = Pattern.compile("[\u4e00-\u9fa5]");

    private RegexUtils() { }

    /**
     * 校验手机号是否正确.
     * <p></p>
     * @param mobiles
     * @return isMobileNO
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static boolean isMobileNO(String mobiles) {
        Matcher m = mobile.matcher(mobiles);
        return m.matches();
    }

    /**
     * 校验邮箱是否正确.
     * <p></p>
     * @param email
     * @return isEmail
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 校验是否是整数.
     * <p></p>
     * @param value
     * @return isInteger
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 判断是否含有特殊字符.
     * <p></p>
     * @param text
     * @return boolean true,通过，false，没通过
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static boolean hasSpecialChar(String text) {
        if (null == text || "".equals(text)) {
            return true;
        }
        if (text.replaceAll("[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() == 0) {
            // 如果不包含特殊字符
            return false;
        }
        return true;
    }

    /**
     * 判断是否正整数.
     * <p></p>
     * @param number 数字
     * @return boolean true,通过，false，没通过
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static boolean isNumber(String number) {
        if (null == number || "".equals(number)) {
            return false;
        }
        String regex = "[0-9]*";
        return number.matches(regex);
    }

    /**
     * 判断是否是正确的IP地址.
     * <p></p>
     * @param ip
     * @return boolean true,通过，false，没通过
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static boolean isIp(String ip) {
        if (null == ip || "".equals(ip)) {
            return false;
        }
        String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        return ip.matches(regex);
    }

    /**
     * 判断是否含有中文，仅适合中国汉字，不包括标点.
     * <p></p>
     * @param text
     * @return boolean true,通过，false，没通过
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static boolean isChinese(String text) {
        if (null == text || "".equals(text)) {
            return false;
        }
        Matcher m = chinese.matcher(text);
        return m.find();
    }

}
