package com.kingboy.common.utils.image;

import com.kingboy.common.utils.file.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片相关的操作类
 */
public final class ImageUtil {

    static Logger logger = LoggerFactory.getLogger(ImageUtil.class);


    /**
     * 按照给点的比例放大图像
     * 当缩减比例小于等于0时不发生任何变化
     *
     * @param originalImage 图像数据
     * @param withdRatio    宽度缩减比例
     * @param heightRatio   高度缩减比例
     * @return 图像数据
     */
    public static BufferedImage imageMagnifyRatio(BufferedImage originalImage, Integer withdRatio, Integer heightRatio) {
        if (withdRatio <= 0) {
            withdRatio = 1;
        }
        if (heightRatio <= 0) {
            heightRatio = 1;
        }
        int width = originalImage.getWidth() * withdRatio;
        int height = originalImage.getHeight() * heightRatio;
        BufferedImage newImage = new BufferedImage(width, height, originalImage.getType());
        Graphics g = newImage.getGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return newImage;
    }

    /**
     * 按照给点的比例缩小图像
     * 当缩减比例小于等于0时不发生任何变化
     *
     * @param originalImage 图像数据
     * @param withdRatio    宽度缩减比例
     * @param heightRatio   高度缩减比例
     * @return 图像数据
     */
    public static BufferedImage imageShrinkRatio(BufferedImage originalImage, Integer withdRatio, Integer heightRatio) {
        if (withdRatio <= 0) {
            withdRatio = 1;
        }
        if (heightRatio <= 0) {
            heightRatio = 1;
        }
        int width = originalImage.getWidth() / withdRatio;
        int height = originalImage.getHeight() / heightRatio;
        BufferedImage newImage = new BufferedImage(width, height, originalImage.getType());
        Graphics g = newImage.getGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return newImage;
    }

    /**
     * 按倍率缩小图片
     *
     * @param srcImagePath 读取图片路径
     * @param toImagePath  写入图片路径
     * @param widthRatio   宽度缩小比例
     * @param heightRatio  高度缩小比例
     * @throws IOException
     */
    public static void reduceImageByRatio(String srcImagePath, String toImagePath, int widthRatio, int heightRatio) throws IOException {
        File file = new File(srcImagePath);
        try (FileOutputStream out = new FileOutputStream(toImagePath)) {
            //读入文件

            String prefix = FileUtil.suffix(file);
            // 构造Image对象
            BufferedImage srcBuffer = ImageIO.read(file);
            // 按比例缩减图像
            BufferedImage imageBuffer = ImageUtil.imageShrinkRatio(srcBuffer, widthRatio, heightRatio);
            ImageIO.write(imageBuffer, prefix, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 长高等比例缩小图片
     *
     * @param srcImagePath 读取图片路径
     * @param toImagePath  写入图片路径
     * @param ratio        缩小比例
     * @throws IOException
     */
    public static void reduceImageEqualProportion(String srcImagePath, String toImagePath, int ratio) throws IOException {
        File file = new File(srcImagePath);
        try (FileOutputStream out = new FileOutputStream(toImagePath)) {
            //读入文件
            String prefix = FileUtil.suffix(file);
            // 构造Image对象
            BufferedImage srcBuffer = ImageIO.read(file);
            // 按比例缩减图像
            BufferedImage imageBuffer = ImageUtil.imageShrinkRatio(srcBuffer, ratio, ratio);
            ImageIO.write(imageBuffer, prefix, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 按倍率放大图片
     *
     * @param srcImagePath 读取图形路径
     * @param toImagePath  写入入行路径
     * @param widthRatio   宽度放大比例
     * @param heightRatio  高度放大比例
     * @throws IOException
     */
    public static void enlargementImageByRatio(String srcImagePath, String toImagePath,
                                               int widthRatio, int heightRatio) throws IOException {
        File file = new File(srcImagePath);
        try (FileOutputStream out = new FileOutputStream(toImagePath)) {
            //读入文件
            String prefix = FileUtil.suffix(file);
            // 构造Image对象
            BufferedImage srcBuffer = ImageIO.read(file);
            // 按比例缩减图像
            BufferedImage imageBuffer = ImageUtil.imageMagnifyRatio(srcBuffer, widthRatio, heightRatio);
            ImageIO.write(imageBuffer, prefix, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 长高等比例放大图片
     *
     * @param srcImagePath 读取图形路径
     * @param toImagePath  写入入行路径
     * @param ratio        放大比例
     * @throws IOException
     */
    public static void enlargementImageEqualProportion(String srcImagePath, String toImagePath, int ratio) throws IOException {
        File file = new File(srcImagePath);
        try (FileOutputStream out = new FileOutputStream(toImagePath)) {
            //读入文件
            String prefix = FileUtil.suffix(file);
            // 构造Image对象
            BufferedImage srcBuffer = ImageIO.read(file);
            // 按比例缩减图像
            BufferedImage imageBuffer = ImageUtil.imageMagnifyRatio(srcBuffer, ratio, ratio);
            ImageIO.write(imageBuffer, prefix, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
