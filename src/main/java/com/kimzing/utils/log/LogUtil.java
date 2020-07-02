package com.kimzing.utils.log;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 日志打印工具.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/26 15:15
 */
public final class LogUtil {

    private static Cache<String, Logger> loggerCacher = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .build();

    /**
     * Debug级别日志
     *
     * @param format
     * @param args
     */
    public static void debug(String format, Object... args) {
        Logger logger = getLogger();
        if (logger.isDebugEnabled()) {
            logger.debug(format, args);
        }
    }

    /**
     * Info级别日志
     *
     * @param format
     * @param args
     */
    public static void info(String format, Object... args) {
        Logger logger = getLogger();
        if (logger.isInfoEnabled()) {
            logger.info(format, args);
        }
    }

    /**
     * Warn级别日志
     *
     * @param format
     * @param args
     */
    public static void warn(String format, Object... args) {
        Logger logger = getLogger();
        if (logger.isWarnEnabled()) {
            logger.warn(format, args);
        }
    }

    /**
     * Error级别日志
     *
     * @param format
     * @param args
     */
    public static void error(String format, Object... args) {
        Logger logger = getLogger();
        if (logger.isErrorEnabled()) {
            logger.error(format, args);
        }
    }

    /**
     * 获取日志工具
     * <p>
     * 为了减少创建开销，引入缓存机制
     * </p>
     *
     * @return
     */
    private static Logger getLogger() {
        String classNameOfCaller = getClassNameOfCaller();
        Logger logger = loggerCacher.getIfPresent(classNameOfCaller);
        if (Objects.nonNull(logger)) {
            return logger;
        }
        logger = LoggerFactory.getLogger(classNameOfCaller);
        loggerCacher.put(classNameOfCaller, logger);
        return logger;
    }

    private static String getClassNameOfCaller() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return stackTrace[2].getClassName();
    }

}
