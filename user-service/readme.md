# User-service

CRUD service for managing users. It should use persistent storage for storing users

## Run
To run the service you need to define env values:
To run the service you need to define env values:
- SERVICE_PORT;
- DB_JDBC;
- DB_LOGIN;
- DB_PASSW;

Example:
```shell
  java -DSERVICE_PORT=8081 -DDB_JDBC=jdbc:h2:mem:userdb -DDB_LOGIN=sa -DDB_PASSW=pwd -jar ./build/libs/user-service-0.0.1-SNAPSHOT.jar
```

## DB Console
DB_username/password from variables: DB_LOGIN; DB_PASSW;
http://localhost:8081/h2-console/userdb/

## Endpoints
http://localhost:8081/greeting