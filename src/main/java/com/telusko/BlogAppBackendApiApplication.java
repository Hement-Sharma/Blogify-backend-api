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

	@Bean // @SpringBootApplication --> This annotation also treated as @Configuration (so you can define Beans for Ioc)
    public ModelMapper modelMapper(){        //We can declear our own config class...
		return new ModelMapper();
	}

}
