# User-service

CRUD service for managing users. It should use persistent storage for storing users

## Run locally
To run the service you need to define env values:
- DB_JDBC;
- DB_LOGIN;
- DB_PWD;

Example:
```shell
  java -DDB_JDBC=jdbc:h2:mem:userdb -DDB_LOGIN=sa -DDB_PWD=pwd -jar ./build/libs/user-service-0.0.2.jar
```

## Build and Run with Docker
```shell
docker build -t vzateychuk/user-service:2.0.0 .
docker run --name=user-service --env DB_JDBC=jdbc:h2:mem:userdb --env DB_LOGIN=sa --env DB_PWD=pwd -p 8081:8080 -d -ti vzateychuk/user-service:2.0.0
```

## DB Console
DB_username/password from variables: DB_LOGIN; DB_PWD;
http://localhost:8081/h2-console/userdb/

## Endpoints
http://localhost:8081/greeting
http://localhost:8081/users/