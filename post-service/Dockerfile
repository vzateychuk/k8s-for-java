FROM amazoncorretto:11

COPY ./build/libs/post-service-0.0.2.jar /app/post-service.jar
WORKDIR /app

CMD ["java", "-jar", "./post-service.jar"]
