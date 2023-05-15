# kubernetes-mentoring-program
Pet project with two services: 
- [User-Service](./user-service) is CRUD service for managing users. Running on port 8081
- [Post-Service](./post-service) is CRUD service for managing posts. Running on port 8082

## Build and upload docker images
run from bash console:
```shell
./build-all.sh
```

## Start services
run commands:
```shell
docker-compose up
```
## Stop services
run commands:
```shell
docker-compose down
```

## Links
[User-service on docker hub](https://hub.docker.com/repository/docker/vzateychuk/user-service/general)
[Post-service on docker hub](https://hub.docker.com/repository/docker/vzateychuk/post-service/general)

[Siarhei_Svila kubernetes-mentoring-program](https://git.epam.com/Siarhei_Svila/kubernetes-mentoring-program/-/blob/main/1-microservices-architecture-and-docker/task/README.md)