package com.maram.training.dto;
public record TrainingSummary(
		long totalTrainees,
		long activeTrainees,
		long totalCourses,
		long totalAssignments,
		long totalSubmissions,
		Double averageScore){}