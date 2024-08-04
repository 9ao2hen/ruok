package com.mervyn.ruok.module.infra.framework.web.config;

import com.mervyn.ruok.framework.swagger.config.RuokSwaggerAutoConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * infra 模块的 web 组件的 Configuration
 *
 * @author mervyn
 */
@Configuration(proxyBeanMethods = false)
public class InfraWebConfiguration {

    /**
     * infra 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi infraGroupedOpenApi() {
        return RuokSwaggerAutoConfiguration.buildGroupedOpenApi("infra");
    }

}
