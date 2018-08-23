package com.kimzing.utils.coordinate;

/**
 * 经纬度相关的阿一些操作.
 *
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
public final class CoordinateUtil {

    private CoordinateUtil() {

    }

    /**
     * 计算地球上任意两点(经纬度)距离
     *
     * @param long1 第一点经度
     * @param lat1  第一点纬度
     * @param long2 第二点经度
     * @param lat2  第二点纬度
     * @return 返回距离 单位：米
     */
    public static double distance(double long1, double lat1, double long2, double lat2) {
        // 地球半径
        double r = 6378137;
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        double a = lat1 - lat2;
        double b = (long1 - long2) * Math.PI / 180.0;
        double sa2 = Math.sin(a / 2.0);
        double sb2 = Math.sin(b / 2.0);
        return 2 * r * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
    }
}
