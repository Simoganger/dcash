package com.dreamcashgroup.dcash.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages={"com.dreamcashgroup.dcash.common", "com.dreamcashgroup.dcash.gateway"})
@EnableJpaRepositories(basePackages={"com.dreamcashgroup.dcash.common", "com.dreamcashgroup.dcash.gateway"})
@ComponentScan(basePackages = "com.dreamcashgroup.dcash")
@EntityScan("com.dreamcashgroup.dcash")
@EnableSwagger2
@EnableZuulProxy
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
