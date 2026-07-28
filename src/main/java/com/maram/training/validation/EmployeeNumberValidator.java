package com.maram.training.validation;
import jakarta.validation.ConstraintValidator; import jakarta.validation.ConstraintValidatorContext;
public class EmployeeNumberValidator implements ConstraintValidator<ValidEmployeeNumber,String>{ public boolean isValid(String v,ConstraintValidatorContext c){return v!=null&&v.matches("TR-\\d{4}");} }
