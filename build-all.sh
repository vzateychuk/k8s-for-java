#! /usr/bin/bash

./gradlew clean bootJar
docker login

cd ./user-service || exit
docker build -t vzateychuk/user-service:4.0.0 ./
docker push vzateychuk/user-service:4.0.0

cd ../post-service || exit
docker build -t vzateychuk/post-service:4.0.0 ./
docker push vzateychuk/post-service:4.0.0

