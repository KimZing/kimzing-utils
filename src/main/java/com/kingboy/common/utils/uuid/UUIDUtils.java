package com.kingboy.common.utils.uuid;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * UUID生成.
 * @author KingBoy - KingBoyWorld@163.com
 * @since 2018-08-07
 */
public final class UUIDUtils {

    private UUIDUtils() { }

    /**
     * 获取UUID，不含有-.
     * @return
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 批量获取UUID.
     * @param size
     * @return
     * @author KingBoy - KingBoyWorld@163.com
     * @since 2018/8/7 02:21
     */
    public static ArrayList<String> getUUIDList(int size) {
        return Stream.iterate(1, item -> item + 1)
                .limit(size)
                .map(item -> getUUID())
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
