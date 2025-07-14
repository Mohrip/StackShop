package com.stackshop.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
   
@SpringBootApplication(scanBasePackages = {"com.stackshop.product", "com.stackshop.fakeStore"})
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
