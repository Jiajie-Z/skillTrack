# SkillTrack

SkillTrack is a Spring Boot learning progress tracker API for education practice platforms. It manages students, skills, questions, practice sessions, answer submissions, mastery scores, and recommendation candidates.

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- H2 for local development and tests
- MySQL with Docker Compose
- JUnit 5
- GitHub Actions

## Features

- Create students, skills, and questions
- Start practice sessions for a student and skill
- Submit answers and automatically grade them
- Track attempts, correct answers, and mastery score per skill
- Recommend follow-up questions from a student's weakest skill
- Run integration tests with H2
- Run the API with MySQL using Docker Compose

## API Overview

| Method | Endpoint | Purpose |
|--------|----------|---------|
| `POST` | `/api/students` | Create a student |
| `POST` | `/api/skills` | Create a skill |
| `POST` | `/api/questions` | Create a question for a skill |
| `POST` | `/api/practice-sessions` | Start a practice session |
| `POST` | `/api/practice-sessions/{sessionId}/answers` | Submit and grade an answer |
| `GET` | `/api/students/{studentId}/progress` | Get skill progress for a student |
| `GET` | `/api/students/{studentId}/recommendations` | Recommend follow-up questions |

## Run Locally

The default local configuration uses H2, so no external database is required.

```bash
mvn spring-boot:run
```

The API runs at:

```text
http://localhost:8080
```

## Run with Docker

Docker Compose starts both MySQL and the Spring Boot API.

```bash
docker compose up --build
```

Stop services:

```bash
docker compose down
```

Stop services and remove MySQL data:

```bash
docker compose down -v
```

## Example API Flow

Create a student:

```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{"name":"Jiajie Zhang","email":"jiajie@example.com"}'
```

Create a skill:

```bash
curl -X POST http://localhost:8080/api/skills \
  -H "Content-Type: application/json" \
  -d '{"name":"Linear equations","subject":"Math"}'
```

Create a question:

```bash
curl -X POST http://localhost:8080/api/questions \
  -H "Content-Type: application/json" \
  -d '{"skillId":1,"prompt":"Solve x + 2 = 5","correctAnswer":"3","difficulty":1}'
```

Start a practice session:

```bash
curl -X POST http://localhost:8080/api/practice-sessions \
  -H "Content-Type: application/json" \
  -d '{"studentId":1,"skillId":1}'
```

Submit an answer:

```bash
curl -X POST http://localhost:8080/api/practice-sessions/1/answers \
  -H "Content-Type: application/json" \
  -d '{"questionId":1,"submittedAnswer":"3"}'
```

Check progress:

```bash
curl http://localhost:8080/api/students/1/progress
```

Get recommendations:

```bash
curl http://localhost:8080/api/students/1/recommendations
```

## Testing

Run the test suite:

```bash
mvn test
```

GitHub Actions runs the same test command on every push and pull request.
