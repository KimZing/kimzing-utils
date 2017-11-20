package com.kingboy.common.utils;

import com.kingboy.common.utils.page.PageResultFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/11/20 下午6:04
 * @desc 公共模块自动配置累.
 */
@Configuration
@ConditionalOnClass({ PageResultFactory.class })
public class CommonAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(PageResultFactory.class)
    @ConditionalOnProperty(name = "page.enabled", matchIfMissing = true)
    public PageResultFactory authorResolver() {
        PageResultFactory pageResultFactory = new PageResultFactory();
        return pageResultFactory;
    }
}
