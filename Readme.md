# COCKPIT API

Build Restful CRUD API for the COCKPIT-API application using Spring Boot, Mysql, JPA and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**


**2. Create Mysql database**
```bash
create database cockpit
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**2. Build and run the app using maven**

```bash
mvn package
java -jar target/cockpit-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/customers
    
    POST /api/customers
    
    GET /api/customers/{noteId}
    
    PUT /api/customers/{noteId}
    
    DELETE /api/customers/{noteId}

You can test them using postman or any other rest client.


