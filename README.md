# Insurance Advisor Application

###Main technical decisions

Strategy Design Pattern - I choosed use this pattern because The risk algorithm could generate a big 
complexity cyclomatic which could difficult the maintenance of the code. And we can remove some rule of our algorithm
without big difficult!

DOCKER - I used docker and docker compose because simplify as we run our application.

Tests - Was created integration tests, because we can validate full algorithm. But if we want, as the code was built
is simple to create unit tests.

LOGGER - I used logs because, with them, we can see all happens with our application. And if we need to troubleshoot is
easier to identify the problem.

###Run with DOCKER

`docker-compose build`
`docker-compose up`

Obs: Maybe you need run with sudo!

###Run as fat jar
- `mvn clean install`
- Navigate to /insurance-advisor/target
- Execute command `java -jar -Xms512m -Xmx512m [***PATH WHERE YOU CLONE PROJECT***]/target/insurance-advisor-1.0.0.jar --spring.config.location=file:'[***PATH WHERE YOU CLONE PROJECT***]/src/main/resources/application.yml` `

OBS: I would that you run with docker - more easy.

### Frameworks and libs

| Frameworks and libs |
| ------ |
| Spring Boot Starter Web |
| Spring Boot Starter Validation |
| Apache Commons lang3 |
| JUnit |