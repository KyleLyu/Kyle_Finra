package com.kyle.demo;

import com.kyle.demo.service.FileService;
import com.kyle.demo.utility.StorageInfo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageInfo.class)
public class KyleFinraApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyleFinraApplication.class, args);
	}

	@Bean
	CommandLineRunner init(FileService fileService) {
		return (args) -> {
			fileService.deleteAll();
			fileService.init();
		};
	}
}
