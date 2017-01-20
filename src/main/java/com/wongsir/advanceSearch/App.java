package com.wongsir.advanceSearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/** 
* @Description: springboot ������ 
* @author hjd
* @date 2017��1��19�� ����9:23:27 
*  
*/
@SpringBootApplication
public class App extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
