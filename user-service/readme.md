# User-service

CRUD service for managing users. It should use persistent storage for storing users

## Run locally
To run the service you need to define env values:
- DB_HOST;
- DB_PORT;
- DB_NAME;
- DB_LOGIN;
- DB_PWD;

## Build and Run with Docker
run commands:
```shell
docker run --name=postgres-userdb -it -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=pwd -e POSTGRES_DB=userdb -p 5433:5432 -d postgres:latest
docker build -t vzateychuk/user-service:5.0.0 .
docker run --name=user-service -e DB_HOST=host.docker.internal -e DB_NAME=userdb -e DB_PORT=5433 -e DB_LOGIN=admin -e DB_PWD=pwd -p 8081:8080 -d -ti vzateychuk/user-service:5.0.0
```

## Endpoints
http://localhost:30081/greeting
http://localhost:30081/users/

### Healthcheck
http://localhost:30081/health/live
http://localhost:30081/health/ready