package com.maram.training.service; 
import com.maram.training.entity.Trainee; 
import java.util.*;
public interface TraineeService{List<Trainee> all(String s,String d); List<Trainee> active(boolean a,String s,String d);
Trainee one(Long id); Trainee create(Trainee t); Trainee replace(Long id,Trainee t); Trainee setActive(Long id,boolean a); 
void delete(Long id);}