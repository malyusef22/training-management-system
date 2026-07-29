package com.maram.training.service;

import com.maram.training.dto.TrainingSummary; 
import com.maram.training.repository.*; 
import org.springframework.data.domain.Sort; 
import org.springframework.stereotype.Service;

@Service 
public class SummaryService{
	private final TraineeRepository t;
	private final CourseRepository c;
	private final AssignmentRepository a;
	private final AssignmentSubmissionRepository s;
	public SummaryService(TraineeRepository t,
			CourseRepository c,
			AssignmentRepository a,
			AssignmentSubmissionRepository s){this.t=t;this.c=c;this.a=a;this.s=s;}
	public TrainingSummary get(){
		return new TrainingSummary(t.count(),t.findByActive(true,Sort.unsorted()).size(),c.count(),a.count(),s.count(),s.findAverageScore());}}