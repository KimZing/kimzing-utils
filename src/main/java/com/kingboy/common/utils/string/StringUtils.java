package com.kingboy.common.utils.string;


import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类.
 *
 * @author KingBoy - KingBoyWorld@163.com
 * @since 2018-08-07 02:02
 */
public class StringUtils {

    /**
     * 是否为空.
     * <p>
     *      "" => true;
     *      " " => true
     *      "a"  false
     * </p>
     * @param cs
     * @return
     */
    public static boolean isBlank(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isBlank(cs);
    }

    /**
     * 是否为空.
     * <p>
     *      ""    true
     *      "  "  false
     *      "a"   false
     * </p>
     * @param cs
     * @return
     */
    public static boolean isEmpty(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isEmpty(cs);
    }

    /**
     * 去除空格.
     * <p>
     *      null   null
     *      "a  "  "a"
     *      "  a"  "a"
     * </p>
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

    /**
     * 页面中去除字符串中的空格、回车、换行符、制表符.
     *
     * @param str 需要处理的字符串
     */
    public static String replaceBlank(String str) {
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            str = m.replaceAll("");
        }
        return str;
    }

    /**
     * 字符串相似度比较(速度较快).
     *
     * @param str1
     * @param str2
     * @return double
     */
    public static double similarityRatio(String str1, String str2) {
        str1 = isEmpty(str1) ? "" : str1.replaceAll("[\\pP\\p{Punct}]", "");
        str2 = isEmpty(str2) ? "" : str2.replaceAll("[\\pP\\p{Punct}]", "");
        if (str1.length() > str2.length()) {
            return similarityRatio(str1, str2);
        } else {
            return similarityRatio(str2, str1);
        }

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
        if ((cs[0] >= 'a') && (cs[0] <= 'z')) {
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
        if ((cs[0] >= 'A') && (cs[0] <= 'Z')) {
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

    private static int compare(String str, String target) {
        int[][] d; // 矩阵
        int n = str.length();
        int m = target.length();
        int i; // 遍历str的
        int j; // 遍历target的
        char ch1; // str的
        char ch2; // target的
        int temp; // 记录相同字符,在某个矩阵位置值的增量,不是0就是1
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        d = new int[n + 1][m + 1];
        for (i = 0; i <= n; i++) { // 初始化第一列
            d[i][0] = i;
        }

        for (j = 0; j <= m; j++) { // 初始化第一行
            d[0][j] = j;
        }

        for (i = 1; i <= n; i++) { // 遍历str
            ch1 = str.charAt(i - 1);
            // 去匹配target
            for (j = 1; j <= m; j++) {
                ch2 = target.charAt(j - 1);
                if (ch1 == ch2) {
                    temp = 0;
                } else {
                    temp = 1;
                }

                // 左边+1,上边+1, 左上角+temp取最小
                d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
            }
        }
        return d[n][m];
    }

    private static int min(int one, int two, int three) {
        if (one <= two) {
            return one < three ? one : three;
        }
        return two < three ? two : three;
    }

}
