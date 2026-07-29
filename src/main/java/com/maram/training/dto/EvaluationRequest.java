package com.maram.training.dto; 

import jakarta.validation.constraints.*; 

public record EvaluationRequest(
		@NotNull
		@PositiveOrZero 
		Double score,
		String trainerComment){}