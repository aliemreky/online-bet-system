# Online Bet Application

## Tech Stack
- Java 17
- Spring Boot 3.x
- H2 Database
- Spring Cache
- Spring Scheduler
- Spring Web Socket
- Hexagonal Architecture
- Domain Driven Design

## Project Initialize

    First,
    mvn clean compile package install

    After,
    cd application
    java -jar target/application-1.0-SNAPSHOT.jar

**Postman Collection**

    You can use postman collection from 'OnlineBetApplication.postman_collection.json'

**Real Time Match Rates Logs Web Socket Endpoint**
```  
ws://localhost:8080/match-logs
``` 
