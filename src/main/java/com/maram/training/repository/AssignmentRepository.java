package com.maram.training.repository; 

import com.maram.training.entity.Assignment; 
import org.springframework.data.jpa.repository.JpaRepository; 
import java.util.*; 

public interface AssignmentRepository 
extends JpaRepository<Assignment,Long>{List<Assignment> findByCourseId(Long id);}