# Deviation Micro Service

Created by Tom Aylen on 31/01/2020.

This microservice find the deviation of the greatest 3 intergers given to it.

## Run
Run with Maven command `.\mvnw spring-boot:run`

Micro service is listening on `http://localhost:8080/deviation` add input data as a paramter with `?data=`

example to find deviation of [5, 4, 6, 1] got to `http://localhost:8080/deviation?data=5,4,6,1`

### Test
Run tests with command `mvn test`