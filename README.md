 Training Management System — COOP Backend Project

Complete individual Spring Boot project using Java 17, MySQL, JPA/Hibernate, REST APIs, Security, Thymeleaf, Swagger, Maven, Git and Podman.

## Entities and roles
Business entities: Trainee, Course, Assignment, AssignmentSubmission. Security tables: users, authorities. Roles: ADMIN, TRAINER, TRAINEE.

Demo users: `admin/Admin123!`, `trainer/Trainer123!`, `trainee/Trainee123!`.

## Business rules
1. Employee number and email are unique. 
2. Inactive trainees cannot submit. 
3. Duplicate submission is blocked. 
4. Score must be 0..maximumScore. 
5. Course code is unique.

## Architecture
`controller -> service interface -> implementation -> repository -> MySQL`. Constructor injection is used. NotificationService has two implementations; `@Primary` and `@Qualifier` are demonstrated. `@Configuration`, `@Bean`, `@Value`, custom validation, `@InitBinder`, and `@ControllerAdvice` are included.

## Run locally
1. Start MySQL. 2. Confirm root password is `123456` or change `application.properties`. 3. Run:
```bash
mvn clean package
mvn spring-boot:run
```
Application: `http://localhost:8085`

## Main URLs
- Thymeleaf: `http://localhost:8085/trainees`
- Swagger: `http://localhost:8085/swagger-ui.html`
- OpenAPI: `http://localhost:8085/v3/api-docs`
- Actuator: `http://localhost:8085/actuator/health` and `/actuator/info`

## APIs
`/api/trainees`, `/api/courses`, `/api/assignments`, `/api/submissions`, `/api/summary/training`. Includes GET, POST, PUT, PATCH, DELETE, filtering, sorting, custom finders, AVG summary, 404 and 403.

## Podman on Windows
```cmd
Set-ExecutionPolicy -Scope Process Bypass
./podman-run.ps1
```
The MySQL hostname inside the network is `training-mysql`, not localhost. Show `podman images`, `podman ps`, `podman logs training-app`, then test one GET, one write, and one 403.

## Deliverables included
README, ERD, schema.sql, sample_data.sql, queries.sql with JOIN/AVG/VIEW, Dockerfile, .dockerignore, PowerShell Podman script, Postman collection, Swagger, Thymeleaf list/add form, Actuator and security.

## Git workflow
```bash
git init
git add .
git commit -m "chore: initialize project"
git checkout -b feature/training-core
git add .
git commit -m "feat: add training management modules"
git checkout main
git merge feature/training-core
git remote add origin YOUR_GITHUB_URL
git push -u origin main
```
Use meaningful commits for CRUD, validation, security, Thymeleaf, Swagger, Postman and Podman.

Maram Saleh Alyusef