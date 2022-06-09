# Mini-Project-2: E-Store
In this project we're (studentID: 613799, 613812) implemented eStore service, contains 9 microservices. This time we tried to create all services from the scratch for learning microservice architecture.
We implemented discovery service, config service, api gateway and user sign up and sign in with JWT token and other microservices. 

Also, we used Cloud Vault for our secret management and minkube's secret management. 

First time when apply YAML files it will be take some time to download images. Please wait to load next YML file until previous deployment is successful.
kubectl apply -f "file name"
## Tech stacks
1. Spring boot 
2. JJWT (json web token)
3. Docker
4. Kubernetes
5. MySQL 
6. Vault

## Services
1. Eureka discovery service
2. Config server
3. OpenFeign api gateway
4. Estore services
    1. Product
    2. Account
    3. Order
    4. Payment
    5. Transaction
    6. Shipping

### Docker commands

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

### Kubernetes commands
````
1. Start minikube with expose ports
minikube start --driver=docker --ports=30090:30090,30091:30091,30092:30092

2. Open minikube dashboard 
minikube dashboard

3. Deploy secrets
kubectl apply -f mysql-secret.yaml
kubectl apply -f product-secret.yaml

4. Deploy services
kubectl apply -f mysql-deployment.yaml
# project-microservice-api-gateway

````
### Endpoints

### User
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
### Product
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

#### Delete product

```
DELETE /gateway/product/{id} HTTP/1.1
Host: localhost:5555
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MSwiZXhwIjoxNjU0NDc0MDcyfQ.94T7Ah3ww5qLkoq2Tnh2eld7CjxvfULSD1qXiMuL5tqWyN5t75-7uvjZQwEcy_U_NWmmDy7Z_joJiy5mLIpCLw

{
    "id": 1
}

```

### Order
#### Save Order

````
POST /api/order HTTP/1.1
Host: localhost:4444
Authorization: Basic cmFuZG9tU2VjdXJlS2V5VXNlcm5hbWUhOnJhbmRvbVNlY3VyZUtleVBhc3N3b3JkIQ==
Content-Type: application/json

{
    "userId": 1,
    "productId":1,
    "shipping": "address",
    "payment": "paypal"
}
````

#### Get Order Of User

````
GET /api/order/1 HTTP/1.1
Host: localhost:4444
Authorization: Basic cmFuZG9tU2VjdXJlS2V5VXNlcm5hbWUhOnJhbmRvbVNlY3VyZUtleVBhc3N3b3JkIQ==
````

### Payment
#### Get all payment

```
GET /gateway/payment HTTP/1.1
Host: localhost:5555
Content-Type: application/json
```
#### Add payment
```
POST /gateway/payment HTTP/1.1
Host: localhost:5555
Content-Type: application/json
{
  "isPayed": true,
  "paymentStatus": "NOT_STARTED",
  "paymentType": "PAYPAL",
  "paidTime": "2022-06-09T07:50:49.891Z",
  "orderId": 1,
  "totalPrice": 35.25
}
```

#### Get one payment

```
GET /gateway/payment/{id} HTTP/1.1
Host: localhost:5555
Content-Type: application/json
```
