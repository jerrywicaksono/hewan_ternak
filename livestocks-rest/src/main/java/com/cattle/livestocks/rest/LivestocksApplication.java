package com.cattle.livestocks.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan("com.cattle.livestocks.repository.entities")
@ComponentScan(
		basePackages = {
			"com.cattle.livestocks.repository",
			"com.cattle.livestocks.service",
			"com.cattle.livestocks.rest"
		})
@EnableJpaRepositories(
		basePackages = {
			"com.cattle.livestocks.repository"
		})
//@Import({ AsyncConfiguration.class })
@EnableTransactionManagement
public class LivestocksApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivestocksApplication.class, args);
	}
}