FROM amazoncorretto:11

COPY ./build/libs/post-service-*.jar /app/post-service.jar
WORKDIR /app

CMD ["java", "-jar", "./post-service.jar"]
