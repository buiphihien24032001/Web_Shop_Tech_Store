package com.asm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Ps12710BuiphihienAsmJava6Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Ps12710BuiphihienAsmJava6Application.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Ps12710BuiphihienAsmJava6Application.class);
	}

}
