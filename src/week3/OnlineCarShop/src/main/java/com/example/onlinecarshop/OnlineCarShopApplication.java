package com.example.onlinecarshop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "backend API", version = "0.1.3", description = "basic functional"))
public class OnlineCarShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCarShopApplication.class, args);
	}

}
