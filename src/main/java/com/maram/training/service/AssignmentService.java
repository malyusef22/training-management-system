package com.maram.training.service; 
import com.maram.training.dto.AssignmentRequest; 
import com.maram.training.entity.Assignment; 
import java.util.*;
public interface AssignmentService{List<Assignment> all();List<Assignment> byCourse(Long id);
Assignment one(Long id);
Assignment create(AssignmentRequest r);
Assignment replace(Long id,AssignmentRequest r);
Assignment patch(Long id,AssignmentRequest r);
void delete(Long id);}