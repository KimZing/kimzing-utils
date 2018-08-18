package com.kimzing.utils.zip;

import com.kimzing.utils.file.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * ZIP文件操作.
 *
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
public class ZipUtil {

    static Logger logger = LoggerFactory.getLogger(ZipUtil.class);

    /**
     * 文档压缩
     * @param file 需要压缩的文件或目录
     * @param dest 压缩后的文件名称
     * @throws Exception
     */
    public static void deCompress(File file, String dest) throws Exception {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest))) {
            zipFile(file, zos, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文档解压
     *
     * @param source 需要解压缩的文档名称
     * @param path   需要解压缩的路径
     */
    public static void unCompress(File source, String path) throws IOException {
        ZipEntry zipEntry = null;
        FileUtil.createPaths(path);
        // 实例化ZipFile，每一个zip压缩文件都可以表示为一个ZipFile
        // 实例化一个Zip压缩文件的ZipInputStream对象，可以利用该类的getNextEntry()方法依次拿到每一个ZipEntry对象
        try (
                ZipFile zipFile = new ZipFile(source);
                ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(source))
        ) {
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                String fileName = zipEntry.getName();
                File temp = new File(path + "/" + fileName);
                if (!temp.getParentFile().exists()) {
                    boolean success = temp.getParentFile().mkdirs();
                    if (!success) {
                        logger.error("文件创建失败");
                    }
                }
                try (OutputStream os = new FileOutputStream(temp);
                     // 通过ZipFile的getInputStream方法拿到具体的ZipEntry的输入流
                     InputStream is = zipFile.getInputStream(zipEntry)) {
                    int len = 0;
                    while ((len = is.read()) != -1) {
                        os.write(len);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zipFile(File inFile, ZipOutputStream zos, String dir) throws IOException {
        if (inFile.isDirectory()) {
            File[] files = inFile.listFiles();
            if (Objects.nonNull(files) && files.length > 0) {
                for (File file : files) {
                    String name = inFile.getName();
                    if (!"".equals(dir)) {
                        name = dir + "/" + name;
                    }
                    zipFile(file, zos, name);
                }
            }
        } else {
            String entryName = null;
            if (!"".equals(dir)) {
                entryName = dir + "/" + inFile.getName();
            } else {
                entryName = inFile.getName();
            }
            ZipEntry entry = new ZipEntry(entryName);
            zos.putNextEntry(entry);
            try (InputStream is = new FileInputStream(inFile)) {
                int len = 0;
                while ((len = is.read()) != -1) {
                    zos.write(len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
