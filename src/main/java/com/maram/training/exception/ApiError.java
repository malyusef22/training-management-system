package com.maram.training.exception; 

import java.time.*; 
import java.util.*; 

public record ApiError(
		LocalDateTime timestamp,
		int status,
		String error,
		String message,
		String path,
		Map<String,String> validationErrors){}