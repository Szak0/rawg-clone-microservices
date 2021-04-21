# Rawg Clone / Microservices

#### The backend is also available here without Eureka Discovery and loadbalancer: https://github.com/Szak0/rawg-spring-backend

## Requirements to run the application:
- Java 11+
- Maven
- PostgreSQL 12+


## How to run the application?
- First of all you will need to set up a databese with postgreSQL and use the following environment variables: 
PSQL_DB_HOST=<>;PSQL_DB_PORT=<>;PSQL_DB_NAME=<>;PSQL_DB_USERNAME=<>;PSQL_DB_PASSWORD=<>
- Replace '<>' with your credentials.
- clone repository
### The following commands will compile, install, run each submodules: $ mvn compile && mvn install && mvn run
### Run order: 
1. eureka-registry
2. auth-service && game-service
3. api-gateway

### (I'm going to create a shell script soon to make it more simple)


## What does the application do?
These services contains authorization API endpoints, and gathers and serves the game content. It has a discovery service and able to loadbalance.

## Team background
Rawg-clone is a fullstack application developed over 6 sprints in a small team.
### Tech-stack
- Spring Boot
- Spring Security
- Spring Boot data JPA
- Maven
- Lombok
- Swagger2
- Junit
- PostgreSQL
- IntelliJ IDEA


### This project was created only for educational purpose
