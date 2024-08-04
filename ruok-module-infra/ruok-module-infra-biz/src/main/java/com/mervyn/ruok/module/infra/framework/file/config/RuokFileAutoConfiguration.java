package com.mervyn.ruok.module.infra.framework.file.config;

import com.mervyn.ruok.module.infra.framework.file.core.client.FileClientFactory;
import com.mervyn.ruok.module.infra.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件配置类
 *
 * @author mervyn
 */
@Configuration(proxyBeanMethods = false)
public class RuokFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
