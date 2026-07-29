package com.maram.training.config; 

import org.springframework.beans.factory.annotation.Value; 
import org.springframework.context.annotation.*; 

@Configuration 
public class AppConfig{
	@Bean
	ProjectInfo projectInfo(
			@Value
			("${app.project-name}")String n,
			@Value
			("${app.training-company}")String c){
		return new ProjectInfo(n,c);}
	public record ProjectInfo(String name,String company){}}