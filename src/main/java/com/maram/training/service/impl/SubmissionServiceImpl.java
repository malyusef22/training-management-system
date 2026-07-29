package com.maram.training.service.impl;

import com.maram.training.dto.*; 
import com.maram.training.entity.*; 
import com.maram.training.exception.*; 
import com.maram.training.repository.*; 
import com.maram.training.service.*; 
import org.springframework.beans.factory.annotation.Qualifier; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 
import java.time.*; 
import java.util.*;

@Service 
@Transactional
public class SubmissionServiceImpl implements SubmissionService{
	private final AssignmentSubmissionRepository r;
	private final TraineeRepository tr;
	private final AssignmentRepository ar;
	private final NotificationService n;
	public SubmissionServiceImpl(
			AssignmentSubmissionRepository r,
			TraineeRepository tr,
			AssignmentRepository ar,
			@Qualifier("emailNotificationService") NotificationService n)
	{this.r=r;this.tr=tr;this.ar=ar;this.n=n;}public List<AssignmentSubmission> all(){
		return r.findAll();}
	public AssignmentSubmission one(Long id){
		return r.findById(id).orElseThrow(()->new ResourceNotFoundException("Submission not found: "+id));}
	public List<AssignmentSubmission> byTrainee(Long id){
		return r.findByTraineeId(id);}
	public AssignmentSubmission submit(
			SubmissionRequest q){
		Trainee t=tr.findById(q.traineeId()).orElseThrow(()->new ResourceNotFoundException("Trainee not found"));
		Assignment a=ar.findById(q.assignmentId()).orElseThrow(()->new ResourceNotFoundException("Assignment not found"));
		if(!t.isActive())throw new BusinessRuleException("Inactive trainee cannot submit");
		if(r.existsByTraineeIdAndAssignmentId(t.getId(),a.getId()))
			throw new BusinessRuleException("The same assignment cannot be submitted twice");
		AssignmentSubmission s=new AssignmentSubmission();
		s.setTrainee(t);
		s.setAssignment(a);
		s.setContentUrl(q.contentUrl());
		s.setSubmittedAt(LocalDateTime.now());
		s=r.save(s);n.notify("New submission #"+s.getId());
		return s;}
	public AssignmentSubmission evaluate(
			Long id,
			EvaluationRequest q)
	{AssignmentSubmission s=one(id);
	double max=s.getAssignment().getMaximumScore();
	if(q.score()<0||q.score()>max)
		throw new BusinessRuleException("Score must be between 0 and "+max);
	s.setScore(q.score());s.setTrainerComment(q.trainerComment());
	return r.save(s);}
	public void delete(Long id){r.delete(one(id));}}
