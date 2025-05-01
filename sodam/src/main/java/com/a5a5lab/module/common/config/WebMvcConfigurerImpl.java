package com.a5a5lab.module.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//자동으로 함수를 시랭시ㅕ라
@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer{

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new CheckLoginSessionInterceptor())
////		.order(1)
//		.addPathPatterns("/*User*" , "/*Xdm*" , "/*/*Xdm*")
//		.excludePathPatterns(
////				"/resources/**",
//				// 사용자 로그인 안했을때 보여줄수 있는 주소
//				"/*user*",
//			
//				
//			
//				
//				// 관리자 로그인하기전에 로그인 폼만 보여주고 나머지 XX
//				"/*Xdm*/",
//				
//				
//				
//		);
//	
//		
//		WebMvcConfigurer.super.addInterceptors(registry);
//	}
	

}
