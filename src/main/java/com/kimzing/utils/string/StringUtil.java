package com.kimzing.utils.string;


import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类.
 *
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
public class StringUtil {

    private static final char SEPARATOR = '_';

    /**
     * 是否为空.
     * <p>
     * "" => true;
     * " " => true
     * "a"  false
     * </p>
     *
     * @param cs
     * @return
     */
    public static boolean isBlank(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isBlank(cs);
    }

    /**
     * 是否为空.
     * <p>
     * ""    true
     * "  "  false
     * "a"   false
     * </p>
     *
     * @param cs
     * @return
     */
    public static boolean isEmpty(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isEmpty(cs);
    }

    /**
     * 去除空格.
     * <p>
     * null   null
     * "a  "  "a"
     * "  a"  "a"
     * </p>
     *
     * @param s
     * @return
     */
    public static String trim(String s) {
        return org.apache.commons.lang3.StringUtils.trim(s);
    }

    /**
     * 截取字符串超出的字符用symbol代替.
     *
     * @param str    需要处理的字符串
     * @param len    字符串长度
     * @param symbol 最后拼接的字符串
     * @return 测试后的字符串
     */
    public static String subStringSymbol(String str, int len, String symbol) {
        String temp = "";
        if (str != null && str.length() > len) {
            temp = str.substring(0, len) + symbol;
        }
        return temp;
    }

    /**
     * 格式化一个float.
     *
     * @param format 要格式化成的格式 such as #.00, #.#
     * @return 格式化后的字符串
     */
    public static String formatDouble(double f, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(f);
    }

    private static Pattern p = Pattern.compile("\\s*|\t|\r|\n");

    /**
     * 页面中去除字符串中的空格、回车、换行符、制表符.
     *
     * @param str 需要处理的字符串
     */
    public static String replaceBlank(String str) {
        if (str != null) {
            Matcher m = p.matcher(str);
            str = m.replaceAll("");
        }
        return str;
    }

    /**
     * 将字符串首字母转大写.
     *
     * @param str 需要处理的字符串
     */
    public static String upperFirstChar(String str) {
        if (isEmpty(str)) {
            return "";
        }
        char[] cs = str.toCharArray();
        Character start = 'a';
        Character end = 'z';
        if ((cs[0] >= start) && (cs[0] <= end)) {
            cs[0] -= (char) 0x20;
        }
        return String.valueOf(cs);
    }

    /**
     * 将字符串首字母转小写.
     *
     * @param str
     * @return
     */
    public static String lowerFirstChar(String str) {
        if (isEmpty(str)) {
            return "";
        }
        char[] cs = str.toCharArray();
        Character start = 'A';
        Character end = 'Z';
        if ((cs[0] >= start) && (cs[0] <= end)) {
            cs[0] += (char) 0x20;
        }
        return String.valueOf(cs);
    }

    /**
     * 截取字符串左侧指定长度的字符串.
     *
     * @param input 输入字符串
     * @param count 截取长度
     * @return 截取字符串
     */
    public static String left(String input, int count) {
        if (isEmpty(input)) {
            return "";
        }
        count = (count > input.length()) ? input.length() : count;
        return input.substring(0, count);
    }

    /**
     * 截取字符串右侧指定长度的字符串.
     *
     * @param input 输入字符串
     * @param count 截取长度
     * @return 截取字符串
     */
    public static String right(String input, int count) {
        if (isEmpty(input)) {
            return "";
        }
        count = (count > input.length()) ? input.length() : count;
        return input.substring(input.length() - count, input.length());
    }

    /**
     * 判读俩个字符串右侧的length个字符串是否一样.
     *
     * @param str1
     * @param str2
     * @param length
     * @return
     */
    public static boolean rigthEquals(String str1, String str2, int length) {
        return right(str1, length).equals(right(str2, length));
    }

    /**
     * 判读俩个字符串左侧的length个字符串是否一样.
     *
     * @param str1
     * @param str2
     * @param length
     * @return
     */
    public static boolean leftEquals(String str1, String str2, int length) {
        return left(str1, length).equals(left(str2, length));
    }


    /**
     * 字符串转下划线
     */
    public static String toUnderlineName(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i >= 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    if (i > 0) sb.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }

    /**
     * 下划线转驼峰
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线转大写驼峰
     */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    private static int min(int one, int two, int three) {
        if (one <= two) {
            return one < three ? one : three;
        }
        return two < three ? two : three;
    }

}
