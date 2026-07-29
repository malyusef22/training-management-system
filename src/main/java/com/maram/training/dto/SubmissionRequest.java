package com.maram.training.dto; 

import jakarta.validation.constraints.*; 

public record SubmissionRequest(
		@NotNull
		Long traineeId,
		@NotNull
		Long assignmentId,
		@NotBlank
		String contentUrl){}