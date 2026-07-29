package com.maram.training.service.impl; 

import com.maram.training.entity.Course;
import com.maram.training.exception.*; 
import com.maram.training.repository.CourseRepository;
import com.maram.training.service.CourseService;
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 
import java.util.*;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{
	private final CourseRepository r; 
	public CourseServiceImpl(CourseRepository r){this.r=r;} 
	public List<Course> all(){
		return r.findAll();} 
	public List<Course> search(String q){
		return r.findByTitleContainingIgnoreCase(q);} 
	public Course one(Long id){
		return r.findById(id).orElseThrow(()->new ResourceNotFoundException("Course not found: "+id));} 
	public Course create(Course c){
		if(r.existsByCodeIgnoreCase(c.getCode()))
			throw new BusinessRuleException("Course code must be unique");c.setId(null);
			return r.save(c);}
	public Course replace(Long id,Course c){Course x=one(id);
			if(!x.getCode().equalsIgnoreCase(c.getCode())&&r.existsByCodeIgnoreCase(c.getCode()))
				throw new BusinessRuleException("Course code must be unique");x.setCode(c.getCode());x.setTitle(c.getTitle());
				x.setDescription(c.getDescription());
				x.setActive(c.isActive());
				return r.save(x);} 
	public Course patch(Long id,Course c){Course x=one(id);
	if(c.getTitle()!=null)x.setTitle(c.getTitle());
	if(c.getDescription()!=null)
		x.setDescription(c.getDescription());
	x.setActive(c.isActive());
	return r.save(x);}
	public void delete(
			Long id){r.delete(one(id));}}
