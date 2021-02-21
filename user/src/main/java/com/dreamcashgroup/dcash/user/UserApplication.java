package com.dreamcashgroup.dcash.user;

import com.dreamcashgroup.dcash.user.service.InitUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages={"com.dreamcashgroup.dcash"})
@EnableJpaRepositories(basePackages={"com.dreamcashgroup.dcash"})
@ComponentScan(basePackages = "com.dreamcashgroup.dcash")
@EntityScan("com.dreamcashgroup.dcash")
@EnableSwagger2
public class UserApplication implements CommandLineRunner {

	@Autowired
	private InitUserService initUserService;

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initUserService.initAdminAccount();
	}
}
