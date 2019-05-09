package com.example.springbootsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class App {
   public static void main(String[] args) {
	  System.out.println("running");
      SpringApplication.run(App.class, args);
   }
}