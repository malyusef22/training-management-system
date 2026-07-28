# ERD
```mermaid
erDiagram
 TRAINEES ||--o{ ASSIGNMENT_SUBMISSIONS : submits
 COURSES ||--o{ ASSIGNMENTS : contains
 ASSIGNMENTS ||--o{ ASSIGNMENT_SUBMISSIONS : receives
 USERS ||--o{ AUTHORITIES : has
```
