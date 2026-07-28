package com.maram.training.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.*;
@Entity
@Table(name="assignment_submissions",uniqueConstraints=@UniqueConstraint(columnNames={"trainee_id","assignment_id"}))
public class AssignmentSubmission {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(name="content_url",nullable=false) private String contentUrl;
 @Column(name="submitted_at",nullable=false) private LocalDateTime submittedAt;
 private Double score;
 @Column(name="trainer_comment") private String trainerComment;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="trainee_id") @JsonIgnore private Trainee trainee;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="assignment_id") @JsonIgnore private Assignment assignment;
 public AssignmentSubmission(){}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getContentUrl(){return contentUrl;} public void setContentUrl(String v){contentUrl=v;}
 public LocalDateTime getSubmittedAt(){return submittedAt;} public void setSubmittedAt(LocalDateTime v){submittedAt=v;}
 public Double getScore(){return score;} public void setScore(Double v){score=v;}
 public String getTrainerComment(){return trainerComment;} public void setTrainerComment(String v){trainerComment=v;}
 public Trainee getTrainee(){return trainee;} public void setTrainee(Trainee v){trainee=v;}
 public Assignment getAssignment(){return assignment;} public void setAssignment(Assignment v){assignment=v;}
}
