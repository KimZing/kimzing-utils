package com.kingboy.common.utils.random;

import java.util.Random;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/24 上午11:05
 * @desc  随机生成工具类.
 */
public final class RandomUtils {

    private RandomUtils() { }

    private static Random random = new Random();

    /**
     * 获取一个固定长度的随机整数，可当做验证码。
     * @param size 长度
     * @return String
     */
    public static String getRandomNum(int size) {
        return String.valueOf(Math.random()).substring(2, size + 2);
    }

    /**
     * 获取两个数的中间数，包含min和max
     * @param min 最小
     * @param max 最大
     * @return 中间数
     */
    public static int getMidNum(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

}
