package com.maram.training.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record AssignmentRequest(
		@NotBlank 
		String title,
		String description,
		@NotNull
		@FutureOrPresent 
		LocalDate dueDate,
		@NotNull
		@Positive
		Double maximumScore,
		@NotNull 
		Long courseId){}