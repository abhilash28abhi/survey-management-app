# Survey management app

Survey management app is a microservice based application which lets a user create surveys with multiple choice questions.

## Technologies Used

**Server:** Java 8, Spring Boot (2.7.x), H2 In memory database, Junit4, Swagger Open API, Lombok


**Build Tool:** Gradle
## Running the app in local machine

Clone the repository to a directory and run the below commands.

```bash
  git clone https://github.com/abhilash28abhi/survey-management-app.git
  cd survey-management-app
  ./gradlew bootrun
```

Access the API endpoints and documentation at :
```bash
http://localhost:8080/swagger-ui.html
```

Access the H2 in-memory database console at:
```bash
http://localhost:8080/h2-console
```

Use any HTTP client like Postman to invoke the endpoints for the supported funcationalities.

## Build

To build the spring boot app, run the below gradle command

```
./gradlew clean build
```