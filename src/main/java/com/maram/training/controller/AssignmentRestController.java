package com.maram.training.controller; 

import com.maram.training.dto.AssignmentRequest; 
import com.maram.training.entity.Assignment; 
import com.maram.training.service.AssignmentService; 
import jakarta.validation.Valid; 
import org.springframework.http.*; 
import org.springframework.security.access.prepost.PreAuthorize; 
import org.springframework.web.bind.annotation.*; 
import java.util.*;

@RestController 
@RequestMapping("/api/assignments") 
public class AssignmentRestController{
	private final AssignmentService s;
	public AssignmentRestController(AssignmentService s){this.s=s;}
	@GetMapping @PreAuthorize("hasAnyRole('ADMIN','TRAINER','TRAINEE')") 
	public List<Assignment> all(){return s.all();}
	@GetMapping("/{id}") 
	@PreAuthorize("hasAnyRole('ADMIN','TRAINER','TRAINEE')") 
	public Assignment one(@PathVariable Long id){return s.one(id);}
	@GetMapping("/course/{id}") 
	@PreAuthorize("hasAnyRole('ADMIN','TRAINER','TRAINEE')") 
	public List<Assignment> byCourse(@PathVariable Long id){return s.byCourse(id);}
	@PostMapping @ResponseStatus(HttpStatus.CREATED) 
	@PreAuthorize("hasAnyRole('ADMIN','TRAINER')") 
	public Assignment create(
			@Valid @RequestBody AssignmentRequest r){
		return s.create(r);}
	@PutMapping("/{id}") 
	@PreAuthorize("hasAnyRole('ADMIN','TRAINER')") 
	public Assignment replace(@PathVariable Long id,@Valid @RequestBody AssignmentRequest r){
		return s.replace(id,r);}
	@PatchMapping("/{id}") 
	@PreAuthorize("hasAnyRole('ADMIN','TRAINER')") 
	public Assignment patch(
			@PathVariable Long id,
			@RequestBody AssignmentRequest r){
		return s.patch(id,r);}
	@DeleteMapping("/{id}") 
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasRole('ADMIN')") 
	public void delete(
			@PathVariable Long id){s.delete(id);}}
