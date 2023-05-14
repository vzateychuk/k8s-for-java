# Post-service

CRUD service for managing posts. It should use persistent storage for storing posts

## Run
To run the service you need to define env values: 
- DB_JDBC; 
- DB_LOGIN;
- DB_PWD;
- USER_SERVICE_API=http://localhost:8081/users/

Example:
```shell
  java -DDB_JDBC=jdbc:h2:mem:postdb -DDB_LOGIN=sa -DDB_PWD=pwd -DUSER_SERVICE_API=http://localhost:8081/users/ -jar ./build/libs/post-service-0.0.2.jar
```

## Build and Run with Docker
```shell
docker build -t vzateychuk/post-service:2.0.0 .
docker run --name=post-service --env DB_JDBC=jdbc:h2:mem:postdb --env DB_LOGIN=sa --env DB_PWD=pwd --env USER_SERVICE_API=http://localhost:8081/users/ -p 8082:8080 -d -ti vzateychuk/post-service:2.0.0
```


## DB Console
DB_username/password from variables: DB_LOGIN; DB_PWD;
[Open DB console use http://localhost:8082/h2-console/postdb/](http://localhost:8082/h2-console/postdb/)

## Endpoints
http://localhost:8082/greeting
http://localhost:8081/posts/