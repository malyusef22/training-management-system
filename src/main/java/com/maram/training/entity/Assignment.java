package com.maram.training.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.*;
import java.util.*;
@Entity @Table(name="assignments")
public class Assignment {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String title;
 private String description;
 @NotNull @FutureOrPresent @Column(name="due_date") private LocalDate dueDate;
 @NotNull @Positive @Column(name="maximum_score") private Double maximumScore;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="course_id") @JsonIgnore private Course course;
 @OneToMany(mappedBy="assignment",cascade=CascadeType.ALL,orphanRemoval=true) @JsonIgnore private List<AssignmentSubmission> submissions=new ArrayList<>();
 public Assignment(){}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public LocalDate getDueDate(){return dueDate;} public void setDueDate(LocalDate v){dueDate=v;}
 public Double getMaximumScore(){return maximumScore;} public void setMaximumScore(Double v){maximumScore=v;}
 public Course getCourse(){return course;} public void setCourse(Course v){course=v;}
 public List<AssignmentSubmission> getSubmissions(){return submissions;} public void setSubmissions(List<AssignmentSubmission> v){submissions=v;}
}
