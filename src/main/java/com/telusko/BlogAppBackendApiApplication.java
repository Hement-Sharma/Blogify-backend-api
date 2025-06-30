package com.telusko;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;


@SpringBootApplication
public class BlogAppBackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppBackendApiApplication.class, args);
	}

	@Bean
    public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
