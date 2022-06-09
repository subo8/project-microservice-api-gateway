# project-microservice-api-gateway

### Endpoints

#### User sign-up

```
POST /api/auth/sign-up HTTP/1.1
Host: localhost:5555
Authorization: Basic cmFuZG9tU2VjdXJlS2V5VXNlcm5hbWUhOnJhbmRvbVNlY3VyZUtleVBhc3N3b3JkIQ==
Content-Type: application/json

{
    "name": "admin",
    "username": "admin",
    "password": "admin"
}
```

#### User sign in

```
POST /api/auth/sign-in HTTP/1.1
Host: localhost:5555
Content-Type: application/json

{
    "username": "admin",
    "password": "admin"
}
```

#### User change role

```
PUT /api/user/change/ADMIN HTTP/1.1
Host: localhost:5555
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9VU0VSIiwidXNlcklkIjoxLCJleHAiOjE2NTQ0NzM4NDV9.xVY74e8ci_tXPDgm0fKzF3GOISesQyX7ZLWQTgB6CweFlPsfycz5VeC4CtR_iBfQzt6p_L-0399rU_EFQOSyyA

```

#### Get product

```
GET /gateway/product HTTP/1.1
Host: localhost:5555
Content-Type: application/json

```

#### Create product

```
POST /gateway/product HTTP/1.1
Host: localhost:5555
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MSwiZXhwIjoxNjU0NDc0MDcyfQ.94T7Ah3ww5qLkoq2Tnh2eld7CjxvfULSD1qXiMuL5tqWyN5t75-7uvjZQwEcy_U_NWmmDy7Z_joJiy5mLIpCLw

{
    "name": "Converse Chuck Taylor",
    "vendor": "CONVERSE",
    "category": "Sneakers"
}
```

#### Docker commands

````
1.Create jar file
mvn clean install -Dmaven.test.skip

2.Run app with mvn
mvn spring-boot:run

3.Create docker image
docker build . -t subo8/mini2-apigateway

4.Docker run
docker run -d --network=backend --name=apigateway -p 5555:5555 subo8/mini2-apigateway

5. Push images to docker hub
docker login
#Optional
docker tag mini2/eureka:latest subo8/mini2-eureka:latest

docker push subo8/mini2-apigateway

#Optional
4.Create docker file automaticaly by paketobuildpacks
mvn spring-boot:build-image
````