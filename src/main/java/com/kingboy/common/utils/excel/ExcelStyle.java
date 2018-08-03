package com.kingboy.common.utils.excel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/26 下午4:58
 * @desc 设置Excel的样式.使用了build模式，链式赋值
 */
public class ExcelStyle {

    public ExcelStyle() { }

    //对齐方式
    private HorizontalAlignment align;

    //字体  "黑体"等
    private String fontName;

    //是否加粗，对表头不生效
    private boolean isBold;

    //字体大小
    private short size;

    //字体颜色
    private short fontColor;

    //边框粗细
    private BorderStyle borderStyle;

    //背景颜色
    private short backColor;



    public ExcelStyle setAlign(HorizontalAlignment align) {
        this.align = align;
        return this;
    }

    public ExcelStyle setFontName(String fontName) {
        this.fontName = fontName;
        return this;
    }

    public ExcelStyle setBold(boolean bold) {
        isBold = bold;
        return this;
    }

    public ExcelStyle setSize(short size) {
        this.size = size;
        return this;
    }

    public ExcelStyle setFontColor(short fontColor) {
        this.fontColor = fontColor;
        return this;
    }

    public ExcelStyle setBorderStyle(BorderStyle borderStyle) {
        this.borderStyle = borderStyle;
        return this;
    }

    public ExcelStyle setBackColor(short backColor) {
        this.backColor = backColor;
        return this;
    }

    public HorizontalAlignment getAlign() {
        return align;
    }

    public String getFontName() {
        return fontName;
    }

    public boolean isBold() {
        return isBold;
    }

    public short getSize() {
        return size;
    }

    public short getFontColor() {
        return fontColor;
    }

    public BorderStyle getBorderStyle() {
        return borderStyle;
    }

    public short getBackColor() {
        return backColor;
    }
}