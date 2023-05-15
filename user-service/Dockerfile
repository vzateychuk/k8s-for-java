FROM amazoncorretto:11

COPY ./build/libs/user-service-*.jar /app/user-service.jar
WORKDIR /app

CMD ["java", "-jar", "./user-service.jar"]
