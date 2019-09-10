package org.swufefic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

/**
 * SpringBoot initial Framework
 */
@SpringBootApplication
public class Application implements EmbeddedServletContainerCustomizer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        // 重新定义tomcat启动端口
        configurableEmbeddedServletContainer.setPort(8082);
    }
}
