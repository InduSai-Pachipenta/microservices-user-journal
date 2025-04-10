# User & Journal Microservices System

## Author: InduSai Pachipenta

### Project Overview
This project consists of two Spring Boot microservices:
1. **User Service**: Manages user registration, updating details, retrieving information, and user roles. It also integrates **Spring Security** for role-based authentication and authorization and publishes user-related events to a Kafka topic for journaling.
2. **Journal Service**: Consumes events from the Kafka topic (`user-events`), logs them, and persists them in a database. It exposes RESTful API endpoints for retrieving journaled user events and implements role-based access control for accessing journal data.

### Technologies Used:
- **Spring Boot** (Java)
- **Spring Security** (for role-based access control)
- **Kafka** (for inter-service communication)
- **Docker** (for containerization)
- **MySQL** (database)
- **JUnit** (for testing)
- **Maven** (build tool)

### Docker Setup
This project can be run locally using Docker and Docker Compose.

#### Steps to Run the System Locally:
1. Clone the repository:
    ```bash
    git clone https://github.com/InduSai-Pachipenta/microservices-user-journal.git
    cd microservices-user-journal
    ```
2. Build and run the Docker containers using `docker-compose`:
    ```bash
    docker-compose up --build
    ```

3. The microservices should now be running locally. You can interact with the APIs as described below.

---

### REST API Endpoints

#### **User Service**
1. **POST /users/register**  
   Registers a new user with roles.

2. **GET /users/{id}**  
   Retrieves user details by ID.

3. **PUT /users/{id}**  
   Updates user details.

4. **DELETE /users/{id}**  
   Deletes the user.

---

#### **Journal Service**
1. **GET /journals**  
   Retrieves all journaled events.

2. **GET /journals/{id}**  
   Retrieves a specific journal event by ID.

### Running Tests
To run unit and integration tests, you can use Maven:
```bash
mvn test
