# Spring Boot app & Postgresql & Docker compose

### How to run app
By this command 

`./bin/run.sh`


### OR

#### 1. Build app & Dockerfile

`mvn clean install`

#### 2. Run docker-compose

`cd src/main/docker`

`docker-compose up`

**What happens:**

1. Starts Postgresql and waits up to 15 seconds for it to finish ([using wait-for-it](https://github.com/vishnubob/wait-for-it))
2. Starts Spring boot application 






### How to test app

Swagger UI as rest client

http://localhost:8080/swagger-ui.html





