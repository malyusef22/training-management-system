package com.maram.training.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;
@Entity
@Table(name="courses",uniqueConstraints=@UniqueConstraint(columnNames="code"))
public class Course {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false) private String code;
 @NotBlank @Column(nullable=false) private String title;
 private String description;
 private boolean active=true;
 @OneToMany(mappedBy="course",cascade=CascadeType.ALL,orphanRemoval=true) @JsonIgnore private List<Assignment> assignments=new ArrayList<>();
 public Course(){}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getCode(){return code;} public void setCode(String v){code=v;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public boolean isActive(){return active;} public void setActive(boolean v){active=v;}
 public List<Assignment> getAssignments(){return assignments;} public void setAssignments(List<Assignment> v){assignments=v;}
}
