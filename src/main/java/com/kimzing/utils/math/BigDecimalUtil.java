package com.kimzing.utils.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;

/**
 * Bigdecimal运算.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/18 13:36
 */
public class BigDecimalUtil {

    /**建立货币格式化引用*/
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

    /**建立百分比格式化引用*/
    private static final NumberFormat percent = NumberFormat.getPercentInstance();

    /**
     * double转换为BigDecimal
     * @param num
     * @return
     */
    public static BigDecimal convert(double num) {
        return new BigDecimal(Double.toString(num));
    }

    /**
     * float转换为BigDecimal
     * @param num
     * @return
     */
    public static BigDecimal convert(float num) {
        return new BigDecimal(Float.toString(num));
    }

    /**
     * num转换为BigDecimal
     * @param num
     * @return
     */
    public static BigDecimal convert(int num) {
        return new BigDecimal(Integer.toString(num));
    }

    /**
     * long转换为BigDecimal
     * @param num
     * @return
     */
    public static BigDecimal convert(long num) {
        return new BigDecimal(Long.toString(num));
    }

    /**
     * String转换为BigDecimal
     * @param num
     * @return
     */
    public static BigDecimal convert(String num) {
        return new BigDecimal(num);
    }

    /**
     * bigInteger转换为BigDecimal
     * @param num
     * @return
     */
    public static BigDecimal convert(BigInteger num) {
        return new BigDecimal(num);
    }

    /**
     * 加法
     *
     * @param num
     * @param num1
     * @return
     */
    public static BigDecimal add(BigDecimal num, BigDecimal num1) {
        return num.add(num1);
    }


    /**
     * 提供精确的加法运算(默认四舍五入，根据scale保留小数位数)
     *
     * @param num
     * @param num1
     * @param scale
     * @return
     */
    public static BigDecimal add(BigDecimal num, BigDecimal num1, int scale) {
        return num.add(num1).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 减法
     *
     * @param num
     * @param num1
     * @return
     */
    public static BigDecimal sub(BigDecimal num, BigDecimal num1) {
        return num.subtract(num1);
    }


    /**
     * 提供精确的减法运算(默认四舍五入，根据scale保留小数位数)
     *
     * @param num
     * @param num1
     * @param scale
     * @return
     */
    public static BigDecimal sub(BigDecimal num, BigDecimal num1, int scale) {
        return num.subtract(num1).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 乘法
     *
     * @param num
     * @param num1
     * @return
     */
    public static BigDecimal multiply(BigDecimal num, BigDecimal num1) {
        return num.multiply(num1);
    }

    /**
     * 提供精确的乘法运算(默认四舍五入，保留小数位数根据scale确定)
     *
     * @param num
     * @param num1
     * @param scale
     * @return
     */
    public static BigDecimal multiply(BigDecimal num, BigDecimal num1, int scale) {
        return num.multiply(num1).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }


    /**
     * 除法(除法除不尽会抛异常， 所以尽量使用带保留位的除法)
     *
     * @param num
     * @param num1
     * @return
     */
    public static BigDecimal divide(BigDecimal num, BigDecimal num1) {
        return num.divide(num1);
    }


    /**
     * 提供精确的除法运算(默认四舍五入保留两位小数)
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor, int scale) {
        return dividend.divide(divisor, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供精确的取余数运算(小数保留位数根据scale决定)
     *
     * @param dividend
     * @param divisor
     * @param scale
     * @return
     */
    public static BigDecimal balance(BigDecimal dividend, BigDecimal divisor, int scale) {
        return dividend.remainder(divisor).setScale(scale);
    }

    /**
     * 比较BigDecimal,相等返回0,num>num1返回1,num<num1返回-1
     *
     * @param num
     * @param num1
     * @return
     */
    public static int compareTo(BigDecimal num, BigDecimal num1) {
        return num.compareTo(num1);
    }


    /**
     * BigDecimal货币格式化
     *
     * @param money
     * @return
     */
    public static String currencyFormat(BigDecimal money) {
        return currency.format(money);
    }


    /**
     * BigDecimal百分比格式化
     *
     * @param rate
     * @return
     */
    public static String rateFormat(BigDecimal rate) {
        return percent.format(rate);
    }

}
