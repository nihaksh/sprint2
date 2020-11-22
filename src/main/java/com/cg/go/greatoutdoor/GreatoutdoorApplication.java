package com.cg.go.greatoutdoor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cg.go.greatoutdoor.dao.IAuthRepository;
import com.cg.go.greatoutdoor.dao.ICartItemRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {IAuthRepository.class,ICartItemRepository.class})
public class GreatoutdoorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatoutdoorApplication.class, args);
	}


	public void run(String... args) throws Exception {
		
	}
	
}
