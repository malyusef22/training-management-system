package com.maram.training.repository;
import com.maram.training.entity.Trainee; 
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository; 
import java.util.*; 
public interface TraineeRepository extends JpaRepository<Trainee,Long>{
	boolean existsByEmployeeNumberIgnoreCase(String x);
	boolean existsByEmailIgnoreCase(String x); List<Trainee> findByActive(boolean a,Sort s);}