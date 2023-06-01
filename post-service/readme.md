# Post-service

CRUD service for managing posts. It should use persistent storage for storing posts

## Run
To run the service you need to define env values: 
- DB_HOST;
- DB_PORT;
- DB_NAME;
- DB_LOGIN;
- DB_PWD;
- USER_SERVICE_API=http://localhost:8081/users/

## Build and Run with Docker
```shell
docker run --name=postgres-postdb -it -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=pwd -e POSTGRES_DB=postdb -p 5434:5432 -d postgres:latest
docker build -t vzateychuk/post-service:5.0.0 .
docker run --name=post-service -e DB_HOST=host.docker.internal -e DB_NAME=postdb -e DB_PORT=5434 -e DB_LOGIN=admin -e DB_PWD=pwd -e USER_SERVICE_API=http://localhost:8081/users/ -p 8082:8080 -d -ti vzateychuk/post-service:5.0.0
```

## Endpoints
http://localhost:30082/greeting
http://localhost:30082/posts/

### Healthcheck
http://localhost:30082/health/live
http://localhost:30082/health/ready
