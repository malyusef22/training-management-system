package com.maram.training.repository; 
import com.maram.training.entity.AssignmentSubmission; 
import org.springframework.data.jpa.repository.*; 
import java.util.*;
public interface AssignmentSubmissionRepository extends JpaRepository<AssignmentSubmission,Long>{
	boolean existsByTraineeIdAndAssignmentId(Long t,Long a); List<AssignmentSubmission> findByTraineeId(Long id);
	@Query("select avg(s.score) from AssignmentSubmission s where s.score is not null") Double findAverageScore();}