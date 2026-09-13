# Telemedicine Consultation Platform

A web-based telemedicine consultation system built with a separated frontend and backend architecture.

## Features

- Doctor and patient information management
- Online consultation records
- Consultation applications and reports
- Role-based administration and authentication
- Database-backed business data management

## Technology stack

- Backend: Java, Spring Boot, MyBatis Plus, Apache Shiro
- Frontend: Vue 2, Element UI
- Database: MySQL
- Build tools: Maven and npm

## Project structure

```text
.
├── renren-fast/       # Spring Boot backend
├── renren-fast-vue/   # Vue frontend
└── renren-generator/  # Code generator
```

## Local setup

1. Create a MySQL database named `telemedicine`.
2. Import the SQL scripts under `renren-fast/db` as needed.
3. Set `DB_USERNAME` and `DB_PASSWORD` in your environment.
4. Start the backend with Maven from `renren-fast`.
5. Install frontend dependencies and start the Vue application from `renren-fast-vue`.

The repository does not contain production credentials. Configure all database and third-party service credentials locally.
