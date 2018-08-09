package com.kingboy.common.utils.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excel注解，用以生成Excel表格文件.
 * <p></p>
 *
 * @author KingBoy - KingBoyWorld@163.com
 * @since 2018-08-07 02:02
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface Excel {

    /**
     * 列名
     */
    String name() default "";

    /**
     * 宽度
     */
    int width() default 25;

    /**
     * 忽略该字段
     */
    boolean skip() default false;

    /**
     * 日期格式
     */
    String dateFormat() default "yyyy年MM月dd日 HH:mm";

}
