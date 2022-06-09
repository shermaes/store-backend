package com.sofkau.store;

import com.sofkau.store.mapper.StoreMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
    @Bean
	public StoreMapper StoreMapper(){
		return new StoreMapper();
	}

}
