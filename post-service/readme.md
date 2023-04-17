# Post-service

CRUD service for managing posts. It should use persistent storage for storing posts

## Run
To run the service you need to define env values: 
- SERVICE_PORT;
- DB_JDBC; 
- DB_LOGIN;
- DB_PASSW;
- USER_SERVICE_API=http://localhost:8081/users/

Example:
```shell
  java -DSERVICE_PORT=8082 -DDB_JDBC=jdbc:h2:mem:postdb -DDB_LOGIN=sa -DDB_PASSW=pwd -DUSER_SERVICE_API=http://localhost:8081/users/ -jar ./build/libs/post-service-0.0.1-SNAPSHOT.jar
```


## DB Console
DB_username/password from variables: DB_LOGIN; DB_PASSW;
[Open DB console use http://localhost:8082/h2-console/postdb/](http://localhost:8082/h2-console/postdb/)

## Endpoints
http://localhost:8082/greeting