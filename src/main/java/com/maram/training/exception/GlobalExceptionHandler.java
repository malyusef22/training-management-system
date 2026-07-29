package com.maram.training.exception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*; 
import java.time.*;
import java.util.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler
 (ResourceNotFoundException.class) ResponseEntity<ApiError> nf(ResourceNotFoundException e,HttpServletRequest r){
	 return make(HttpStatus.NOT_FOUND,e.getMessage(),r,Map.of());}
 @ExceptionHandler
 (BusinessRuleException.class) ResponseEntity<ApiError> br(BusinessRuleException e,HttpServletRequest r){
	 return make(HttpStatus.BAD_REQUEST,e.getMessage(),r,Map.of());}
 @ExceptionHandler
 (MethodArgumentNotValidException.class) ResponseEntity<ApiError> val(MethodArgumentNotValidException e,HttpServletRequest r){
	 Map<String,String> m=new LinkedHashMap<>();e.getBindingResult().getFieldErrors().forEach(x->m.put(x.getField(),x.getDefaultMessage()));
 return make(HttpStatus.BAD_REQUEST,"Validation failed",r,m);}
 private ResponseEntity<ApiError> make(HttpStatus s,String m,HttpServletRequest r,Map<String,String> v){
	 return ResponseEntity.status(s).body(new ApiError(LocalDateTime.now(),s.value(),s.getReasonPhrase(),m,r.getRequestURI(),v));}
}
