package com.maram.training.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maram.training.validation.ValidEmployeeNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;
@Entity
@Table(name="trainees",uniqueConstraints={@UniqueConstraint(columnNames="employee_number"),@UniqueConstraint(columnNames="email")})
public class Trainee {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ValidEmployeeNumber @Column(name="employee_number",nullable=false) private String employeeNumber;
 @NotBlank @Column(name="full_name",nullable=false) private String fullName;
 @NotBlank @Email @Column(nullable=false) private String email;
 private boolean active=true;
 @OneToMany(mappedBy="trainee",cascade=CascadeType.ALL,orphanRemoval=true) @JsonIgnore private List<AssignmentSubmission> submissions=new ArrayList<>();
 public Trainee(){}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getEmployeeNumber(){return employeeNumber;} public void setEmployeeNumber(String v){employeeNumber=v;}
 public String getFullName(){return fullName;} public void setFullName(String v){fullName=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public boolean isActive(){return active;} public void setActive(boolean v){active=v;}
 public List<AssignmentSubmission> getSubmissions(){return submissions;} public void setSubmissions(List<AssignmentSubmission> v){submissions=v;}
}
