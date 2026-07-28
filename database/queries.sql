USE training_management_db;
SELECT * FROM trainees;
SELECT t.full_name,a.title,s.score FROM assignment_submissions s JOIN trainees t ON t.id=s.trainee_id JOIN assignments a ON a.id=s.assignment_id;
SELECT AVG(score) average_score FROM assignment_submissions WHERE score IS NOT NULL;
CREATE OR REPLACE VIEW trainee_results_view AS SELECT t.employee_number,t.full_name,a.title assignment_title,s.score,a.maximum_score FROM assignment_submissions s JOIN trainees t ON t.id=s.trainee_id JOIN assignments a ON a.id=s.assignment_id;