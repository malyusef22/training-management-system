package com.maram.training.controller; 
import com.maram.training.dto.TrainingSummary; 
import com.maram.training.service.SummaryService; 
import org.springframework.security.access.prepost.PreAuthorize; 
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/summary") 
public class SummaryRestController{
	private final SummaryService s;
	public SummaryRestController(SummaryService s){this.s=s;}
	@GetMapping("/training") @PreAuthorize("hasAnyRole('ADMIN','TRAINER')") 
	public TrainingSummary get(){
		return s.get();}}