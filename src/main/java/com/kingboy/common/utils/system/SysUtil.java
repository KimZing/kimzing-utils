package com.kingboy.common.utils.system;

import com.kingboy.common.utils.property.PropertiesUtil;
import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.util.Objects;

/**
 * 提供些获取系统信息相关的工具方法.
 *
 * @author KingBoy - KingBoyWorld@163.com
 * @since 2018-08-07 02:02
 */
public class SysUtil {

    /**
     * JVM的版本
     */
    public static final String JVM_VERSION = PropertiesUtil.key("java.version");

    /**
     * JVM的编码
     */
    public static final String JVM_ENCODING = PropertiesUtil.key("file.encoding");

    /**
     * JVM默认的临时目录
     */
    public static final String JVM_TEMPDIR = PropertiesUtil.key("java.io.tmpdir");
    public static final String HTTP_PROXY_HOST = "http.proxyHost";
    public static final String HTTP_PROXY_PORT = "http.proxyPort";
    public static final String HTTP_PROXY_USER = "http.proxyUser";
    public static final String HTTP_PROXY_PASSWORD = "http.proxyPassword";


    /**
     * 主机架构
     */
    public static final String OS_ARCH = PropertiesUtil.key("os.arch");

    /**
     * 主机类型
     */
    public static final String OS_NAME = PropertiesUtil.key("os.name");

    /**
     * 主机类型版本
     */
    public static final String OS_VERSION = PropertiesUtil.key("os.version");

    /**
     * 操作系统类型
     */
    public static final String SUN_DESKTOP = PropertiesUtil.key("sun.desktop");

    /**
     * 当前用户
     */
    public static final String CURRENT_USER = PropertiesUtil.key("user.name");

    /**
     * 当前用户的家目录
     */
    public static final String CURRENT_USER_HOME = PropertiesUtil.key("user.home");

    /**
     * 当用用户的工作目录
     */
    public static final String CURRENT_USER_DIR = PropertiesUtil.key("user.dir");
    public static final String FILE_SEPARATOR = PropertiesUtil.key("file.separator");
    public static final String PATH_SEPARATOR = PropertiesUtil.key("path.separator");
    public static final String LINE_SEPARATOR = PropertiesUtil.key("line.separator");

    /**
     * 总的物理内存
     */
    private static long totalMemorySize;
    private static OperatingSystemMXBean osmxb;
    private static final  int KB = 1024;

    static {
        osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        totalMemorySize = osmxb.getTotalPhysicalMemorySize() / KB;
    }

    /**
     * 已使用的物理内存
     */
    public static long usedMemory() {
        if (Objects.nonNull(osmxb)) {
            return (osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize()) / KB;
        }
        return 0;
    }

    /**
     * 获取JVM内存总量
     */
    public static long jvmTotalMem() {
        return Runtime.getRuntime().totalMemory() / KB;
    }

    /**
     * 虚拟机空闲内存量
     */
    public static long jvmFreeMem() {
        return Runtime.getRuntime().freeMemory() / KB;
    }

    /**
     * 虚拟机使用最大内存量
     */
    public static long jvmMaxMem() {
        return Runtime.getRuntime().maxMemory() / KB;
    }

    /**
     * Sets HTTP proxy settings.
     */
    public static void setHttpProxy(String host, String port, String username, String password) {
        System.getProperties().put(HTTP_PROXY_HOST, host);
        System.getProperties().put(HTTP_PROXY_PORT, port);
        System.getProperties().put(HTTP_PROXY_USER, username);
        System.getProperties().put(HTTP_PROXY_PASSWORD, password);
    }

    /**
     * Sets HTTP proxy settings.
     */
    public static void setHttpProxy(String host, String port) {
        System.getProperties().put(HTTP_PROXY_HOST, host);
        System.getProperties().put(HTTP_PROXY_PORT, port);
    }

}
