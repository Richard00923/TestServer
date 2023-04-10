# TestServer
TestServer is a Java-based Spring Boot project that demonstrates a basic RESTful API with in-memory H2 database, JWT-based security, and JUnit tests. This project is a test task for Junior Java Software Engineers and can be used as a starting point for learning Spring Boot, Spring Data, and Apache Maven.

# Table of Contents
Technologies Used
Getting Started
API Endpoints
Testing
Curl Commands
Postman Collection
# Technologies Used
Java 8
Spring Boot
Spring Data
Apache Maven
H2 Database
JWT-based Security
JUnit
# Getting Started
Clone the project from GitHub:



git clone ```https://github.com/Richard00923/TestServer.git```
Change directory to the project folder:

```bash Copy code cd TestServer```
Run the project with the Maven Wrapper:

For Unix/Linux/Mac:
```./mvnw spring-boot:run```

 For Windows:
```.\mvnw.cmd spring-boot:run```
The application will start on http://localhost:8080.
# API Endpoints
Get all Users whose age is greater than some value:



```GET /api/users/age/{age}```
```Get all Users from Articles, in which color is a certain value from the enum:```


```GET /api/users/articles/color/{color}```
```Get unique names from Users with more than 3 Articles:```



```GET /api/users/with-more-than-three-articles```
Save User:


```POST /api/users```
Save Article:

```POST /api/articles```
 # Testing
This project includes 1-2 JUnit tests for the API methods at the controller, service, and DAO levels. To run the tests, execute the following command in the project directory:

For Unix/Linux/Mac:

```./mvnw test```
For Windows:


```.\mvnw.cmd test```
# Curl Commands
To test the API endpoints using curl, you can use the following commands:

Authenticate and get JWT token:


```curl -X POST -H "Content-Type: application/json" -d '{"username": "javainuse", "password": "password"}'``` ```http://localhost:8080/api/authenticate```
Replace TOKEN with the JWT token obtained in the previous step and use it in the subsequent commands:


```curl -H "Authorization: Bearer TOKEN" http://localhost:8080/api/users/age/25```
```curl -H "Authorization: Bearer TOKEN" http://localhost:8080/api/users/articles/color/RED```
```curl -H "Authorization: Bearer TOKEN" http://localhost:8080/api/users/with-more-than-three-articles```
# Postman Collection
You can also use Postman to test the API endpoints. Import the Postman collection from the following link:
https://github.com/Richard00923/TestServer/blob/master/TestServer.postman_collection.json
