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

# Kubernetes implementation
In subfolder [k8s](./k8s) there is kubernetes configuration:
- Namespace (f.e. k8s-program). All other objects will use this namespace;
- 2 Services (user/post services). NodePort service type used;
- 2 Deployments (user/post);

## To run
run
```shell
docker run --name=postgre-user -it -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=pwd -e POSTGRES_DB=userdb -p 5433:5432 -d postgres:latest
docker run --name=postgre-post -it -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=pwd -e POSTGRES_DB=postdb -p 5434:5432 -d postgres:latest
kubectl apply -f ./namespace.yaml
kubectl apply -f ./user-srv.yaml
kubectl apply -f ./post-srv.yaml
``` 
in current folder (k8-demo).

To view all objects created by Kubernetes, run:
```shell
kubectl get all -n=<your_namespace>
```
Where *your_namespace* = **k8-vez** in this case.
Along with services and deployments, this command outputs pods and replica-sets.

## To un-deploy
run
```shell
kubectl delete -f ./user-srv.yaml
kubectl delete -f ./post-srv.yaml
``` 
in current folder.
This will delete all objects created.

## Links
[User-service on docker hub](https://hub.docker.com/repository/docker/vzateychuk/user-service/general)
[Post-service on docker hub](https://hub.docker.com/repository/docker/vzateychuk/post-service/general)

[Siarhei_Svila kubernetes-mentoring-program](https://git.epam.com/Siarhei_Svila/kubernetes-mentoring-program/-/blob/main/1-microservices-architecture-and-docker/task/README.md)