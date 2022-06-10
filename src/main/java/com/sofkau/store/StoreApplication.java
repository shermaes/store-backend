package com.sofkau.store;

import com.sofkau.store.mapper.StoreMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Raul's Store", version = "1.0", description = "Documentation APIs v1.0"))
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
    @Bean
	public StoreMapper StoreMapper(){
		return new StoreMapper();
	}

}
