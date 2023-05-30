# kubernetes-for-java
This pet project intended for Kubernets self-educational purpose.  

Contains with two Java services: 
- [User-Service](./user-service) is CRUD service for managing users. Running on port 8081
- [Post-Service](./post-service) is CRUD service for managing posts. Running on port 8082
Which suppose to be deployed / run on Kubernets.
- 
## Build and upload images to docker-hub
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
Subfolder [k8s](./k8s) there is kubernetes configuration:
- Namespace (f.e. k8s-program). All other objects will use this namespace;
- 2 Services (user/post services). NodePort service type used;
- 2 Deployments (user/post);

## To run on k8s
Go to subfolder [k8s](./k8s) and run from terminal:
```shell
kubectl apply -f ./
``` 
All objects will be created in namespace 'vez'
To view all objects created by Kubernetes, run:
```shell
kubectl get all -n=vez
```

## To undeploy
run
```shell
kubectl delete -f ./
``` 
This will delete all objects created.

## Decode/View secrets 
```shell
# User
kubectl get secret user-secret -n vez -o jsonpath='{.data.username}' | base64 --decode
kubectl get secret user-secret -n vez -o jsonpath='{.data.password}' | base64 --decode
# Post
kubectl get secret post-secret -n vez -o jsonpath='{.data.username}' | base64 --decode
kubectl get secret post-secret -n vez -o jsonpath='{.data.password}' | base64 --decode
```
## Links
- [User-service on docker hub](https://hub.docker.com/repository/docker/vzateychuk/user-service/general)
- [Post-service on docker hub](https://hub.docker.com/repository/docker/vzateychuk/post-service/general)

[Siarhei_Svila kubernetes-mentoring-program](https://git.epam.com/Siarhei_Svila/kubernetes-mentoring-program/-/blob/main/1-microservices-architecture-and-docker/task/README.md)