package com.kingboy.common.utils.random;

import java.util.Random;

/**
 * 随机生成工具类.
 * <p></p>
 *
 * @author KingBoy - KingBoyWorld@163.com
 * @since 2018-08-07 02:02
 */
public final class RandomUtils {

    /**
     * 随机Random
     */
    private static Random random = new Random();

    /**
     * 获取一个固定长度的随机整数，可当做验证码.
     * <p></p>
     * @param size 长度
     * @return String
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static String getRandomNum(int size) {
        return String.valueOf(Math.random()).substring(2, size + 2);
    }

    /**
     * 获取两个数的中间数，包含min和max.
     * <p></p>
     * @param min 最小
     * @param max 最大
     * @return 中间数
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static int getMidNum(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

}
