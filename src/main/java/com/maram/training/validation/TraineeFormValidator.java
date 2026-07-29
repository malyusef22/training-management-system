package com.maram.training.validation;

import com.maram.training.entity.Trainee;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;
@Component
public class TraineeFormValidator implements Validator{
	public boolean supports(Class<?> c){
		return Trainee.class.isAssignableFrom(c);}
	public void validate(Object o,Errors e){Trainee t=(Trainee)o;
	if(t.getFullName()!=null&&t.getFullName().trim().split("\\s+").length<2)e.rejectValue("fullName","twoWords","Enter first and last name");}}