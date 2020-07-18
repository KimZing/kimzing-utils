package com.kimzing.utils.math;

import java.math.BigDecimal;

import static com.kimzing.utils.math.BigDecimalUtil.currencyFormat;
import static com.kimzing.utils.math.BigDecimalUtil.rateFormat;

/**
 * BigDecimal运算测试.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/7/18 13:45
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal param1 = new BigDecimal("1.11111");
        BigDecimal param2 = new BigDecimal("2.22222");
        BigDecimal param3 = new BigDecimal("6.66666");

        System.out.println("============加法运算-精确==========");
        System.out.println(BigDecimalUtil.add(param1, param2));
        System.out.println(BigDecimalUtil.add(param1, param3));
        System.out.println("============加法运算-四舍五入==========");
        System.out.println(BigDecimalUtil.add(param1, param2, 2));
        System.out.println(BigDecimalUtil.add(param1, param3, 2));

        System.out.println("============减法运算-精确==========");
        System.out.println(BigDecimalUtil.sub(param2, param1));
        System.out.println(BigDecimalUtil.sub(param3, param1));
        System.out.println("============减法运算-四舍五入==========");
        System.out.println(BigDecimalUtil.sub(param2, param1, 2));
        System.out.println(BigDecimalUtil.sub(param3, param1, 2));

        System.out.println("============乘法运算-精确==========");
        System.out.println(BigDecimalUtil.multiply(param2, param1));
        System.out.println(BigDecimalUtil.multiply(param3, param1));
        System.out.println("============乘法运算-四舍五入==========");
        System.out.println(BigDecimalUtil.multiply(param2, param1, 2));
        System.out.println(BigDecimalUtil.multiply(param3, param1, 2));

        System.out.println("============除法运算-精确==========");
        System.out.println(BigDecimalUtil.divide(param2, param1));
        System.out.println(BigDecimalUtil.divide(param3, param1));
        System.out.println("============除法运算-四舍五入==========");
        System.out.println(BigDecimalUtil.divide(param2, param1, 2));
        System.out.println(BigDecimalUtil.divide(param3, param1, 2));

        System.out.println("============取余运算==========");
        System.out.println(BigDecimalUtil.balance(new BigDecimal("3.12"), new BigDecimal("1.2"), 2));
        System.out.println(BigDecimalUtil.balance(new BigDecimal("3"), new BigDecimal("1"), 2));
        System.out.println(BigDecimalUtil.balance(new BigDecimal("3"), new BigDecimal("2"), 2));

        System.out.println("============货币格式化==========");
        String currencyFormat = currencyFormat(param1);
        System.out.println(currencyFormat);

        System.out.println("============百分比格式化==========");
        String rateFormat = rateFormat(param2);
        System.out.println(rateFormat);
    }

}
