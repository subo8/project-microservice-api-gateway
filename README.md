# Mini-Project-2: E-Store
In this project we're (studentID: 613799, 613812) implemented eStore service, contains 9 microservices. This time we tried to create all services from the scratch for learning microservice architecture.
We implemented discovery service, config service, api gateway and user sign up and sign in with JWT token and other microservices. 
We used Cloud Vault for our secret management. Also used minkube's secret management. 

### Please be aware that First time when apply YAML files it will be take some time to download images. Please wait to load next YML file until previous deployment is successful.

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

## Kubernetes commands
````
1. Start minikube with expose ports
minikube start --driver=docker --ports=30090:30090,30060:30060

#FYI
http://127.0.0.1:30060 - API Gateway
http://127.0.0.1:30090 - Eureka Discovery

2. Open minikube dashboard from terminal
minikube dashboard

3. Deploy services and secret
ATTENTION!: 
1. Please wait until the microservices start fully because Minikube takes some time to completely turn on the services.
2. First time when you apply below yml files, you need to wait each services download from Docker Hub then start completely one by one.
3. If you apply all YML files same time, Minikube will be crash!!
4. WE ALREADY ADD INITIAL DATA TO EACH MICROSERVICES!

**YOU MUST FOLLOW NUMBER ORDERING WHEN YOU APPLY**

Files located in Kubernetes folder, pls check it!

kubectl apply -f 1_configmaps.yml
kubectl apply -f 2_mysql-secret.yml
kubectl apply -f 3_mysql.yml
kubectl apply -f 4_eureka.yml
kubectl apply -f 5_config.yml
kubectl apply -f 6_product.yml
kubectl apply -f 7_payment.yml
kubectl apply -f 8_shipment.yml
kubectl apply -f 9_order.yml
kubectl apply -f 10_transcation.yml
kubectl apply -f 11_apigateway.yml

````
## Endpoints

### User
#### User sign-up

```
POST http://127.0.0.1:30060/api/auth/sign-up HTTP/1.1
Authorization: Basic cmFuZG9tU2VjdXJlS2V5VXNlcm5hbWUhOnJhbmRvbVNlY3VyZUtleVBhc3N3b3JkIQ==
Content-Type: application/json

WE ALREADY ADD THIS USER INTO THE DATABASE, PLEASE JUST USE IT!
{
    "username": "admin",
    "password": "admin"
}
```

#### User sign in

```
POST http://127.0.0.1:30060/api/auth/sign-in HTTP/1.1
Content-Type: application/json

{
    "username": "admin",
    "password": "admin"
}
```

#### User change role

```
PUT http://127.0.0.1:30060/api/user/change/ADMIN HTTP/1.1
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9VU0VSIiwidXNlcklkIjoxLCJleHAiOjE2NTQ0NzM4NDV9.xVY74e8ci_tXPDgm0fKzF3GOISesQyX7ZLWQTgB6CweFlPsfycz5VeC4CtR_iBfQzt6p_L-0399rU_EFQOSyyA

```
### Product
#### Get product

```
GET http://127.0.0.1:30060/gateway/product HTTP/1.1
Content-Type: application/json

```

#### Create product

```
POST http://127.0.0.1:30060/gateway/product HTTP/1.1
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MSwiZXhwIjoxNjU0NDc0MDcyfQ.94T7Ah3ww5qLkoq2Tnh2eld7CjxvfULSD1qXiMuL5tqWyN5t75-7uvjZQwEcy_U_NWmmDy7Z_joJiy5mLIpCLw

{
    "name": "Nike-Air",
    "vendor": "Nike",
    "price": 100000.0,
    "categoryId": 1
}
```

#### Delete product

```
DELETE http://127.0.0.1:30060/gateway/product/{id} HTTP/1.1
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MSwiZXhwIjoxNjU0NDc0MDcyfQ.94T7Ah3ww5qLkoq2Tnh2eld7CjxvfULSD1qXiMuL5tqWyN5t75-7uvjZQwEcy_U_NWmmDy7Z_joJiy5mLIpCLw

{
    "id": 1
}

```

### Order
#### Save Order

````
POST http://127.0.0.1:30060/gateway/order/add HTTP/1.1
Authorization: Basic cmFuZG9tU2VjdXJlS2V5VXNlcm5hbWUhOnJhbmRvbVNlY3VyZUtleVBhc3N3b3JkIQ==
Content-Type: application/json

````

#### Get Order Of User

````
GET http://127.0.0.1:30060/gateway/order/1 HTTP/1.1
Authorization: Basic cmFuZG9tU2VjdXJlS2V5VXNlcm5hbWUhOnJhbmRvbVNlY3VyZUtleVBhc3N3b3JkIQ==
````

#### Get All Orders

````
GET http://127.0.0.1:30060/gateway/order HTTP/1.1
Authorization: Basic cmFuZG9tU2VjdXJlS2V5VXNlcm5hbWUhOnJhbmRvbVNlY3VyZUtleVBhc3N3b3JkIQ==
````

### Payment
#### Get all payment

```
GET http://127.0.0.1:30060/gateway/payment HTTP/1.1
Content-Type: application/json
```
#### Add payment
```
POST http://127.0.0.1:30060/gateway/payment HTTP/1.1
Content-Type: application/json
{
  "orderId": 1,
}
```
#### Get one payment

```
GET http://127.0.0.1:30060/gateway/payment/{id} HTTP/1.1
Content-Type: application/json
```
### Shipping
#### Get shipping
```
GET http://127.0.0.1:30060/gateway/shipment HTTP/1.1
Content-Type: application/json
```

#### Add shipping
```
POST http://127.0.0.1:30060/gateway/shipment HTTP/1.1
Content-Type: application/json
{
  "orderId": 1,
}
```

#### Update shipping
```
GET http://127.0.0.1:30060/gateway/shipment/{id} HTTP/1.1
Content-Type: application/json
{
  "order_id": 1,
}
```

### Transaction
#### Get transaction

```
GET http://127.0.0.1:30060/gateway/transaction HTTP/1.1
Content-Type: application/json
```
