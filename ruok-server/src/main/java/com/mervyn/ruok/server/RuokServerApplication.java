package com.mervyn.ruok.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目的启动类
 *
 * 如果你碰到启动的问题，请认真阅读 https://doc.iocoder.cn/quick-start/ 文章
 * 如果你碰到启动的问题，请认真阅读 https://doc.iocoder.cn/quick-start/ 文章
 * 如果你碰到启动的问题，请认真阅读 https://doc.iocoder.cn/quick-start/ 文章
 *
 * @author mervyn
 */
@SuppressWarnings("SpringComponentScan") // 忽略 IDEA 无法识别 ${ruok.info.base-package}
@SpringBootApplication(scanBasePackages = {"${ruok.info.base-package}.server", "${ruok.info.base-package}.module"})
public class RuokServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuokServerApplication.class, args);

    }

}
