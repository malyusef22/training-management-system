package com.maram.training.config; 
import com.maram.training.entity.*; 
import com.maram.training.repository.*; 
import org.springframework.boot.CommandLineRunner; 
import org.springframework.context.annotation.*; 
import org.springframework.jdbc.core.JdbcTemplate; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import java.time.*;
@Configuration 
public class DataInitializer{
	@Bean CommandLineRunner init(JdbcTemplate j,PasswordEncoder pe,TraineeRepository t,CourseRepository c,AssignmentRepository a){
		return x->{j.execute("CREATE TABLE IF NOT EXISTS users(username VARCHAR(50) PRIMARY KEY,password VARCHAR(100) NOT NULL,enabled BOOLEAN NOT NULL)");
		j.execute("CREATE TABLE IF NOT EXISTS authorities(username VARCHAR(50) NOT NULL,authority VARCHAR(50) NOT NULL,CONSTRAINT fk_auth_users FOREIGN KEY(username) REFERENCES users(username),CONSTRAINT uk_auth UNIQUE(username,authority))");
		user(j,pe,"admin","Admin123!","ROLE_ADMIN");
		user(j,pe,"trainer","Trainer123!","ROLE_TRAINER");
		user(j,pe,"trainee","Trainee123!","ROLE_TRAINEE");
		if(t.count()==0){Trainee t1=new Trainee();
		t1.setEmployeeNumber("TR-1001");t1.setFullName("Maram Saleh");t1.setEmail("maram@ejada.com");t1.setActive(true);t.save(t1);Trainee t2=new Trainee();
		t2.setEmployeeNumber("TR-1002");t2.setFullName("Sara Ahmed");t2.setEmail("sara@ejada.com");t2.setActive(true);t.save(t2);}
		if(c.count()==0){Course c1=new Course();c1.setCode("JAVA-101");c1.setTitle("Java and OOP");c1.setDescription("Java fundamentals");c1.setActive(true);c.save(c1);
		Course c2=new Course();c2.setCode("SPRING-201");c2.setTitle("Spring Boot");c2.setDescription("REST and Security");c2.setActive(true);c.save(c2);
		Assignment a1=new Assignment();a1.setTitle("Java Assignment");a1.setDescription("Student management");a1.setDueDate(LocalDate.now().plusDays(14));a1.setMaximumScore(100.0);a1.setCourse(c1);a.save(a1);
		Assignment a2=new Assignment();a2.setTitle("Spring API");a2.setDescription("Secured REST API");a2.setDueDate(LocalDate.now().plusDays(21));a2.setMaximumScore(100.0);a2.setCourse(c2);a.save(a2);}};}
	private void user(JdbcTemplate j,PasswordEncoder p,String u,String pw,String role){Integer n=j.queryForObject("select count(*) from users where username=?",Integer.class,u);
	if(n!=null&&n==0){j.update("insert into users values(?,?,true)",u,p.encode(pw));j.update("insert into authorities values(?,?)",u,role);}}}
