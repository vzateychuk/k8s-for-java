FROM amazoncorretto:11

COPY ./build/libs/user-service-0.0.2.jar /app/user-service.jar
WORKDIR /app

CMD ["java", "-jar", "./user-service.jar"]
