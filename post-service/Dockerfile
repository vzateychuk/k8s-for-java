FROM amazoncorretto:11

MAINTAINER vzateychuk

COPY ./build/libs/post-service-0.0.1-SNAPSHOT.jar /app/post-service.jar
WORKDIR /app

CMD ["java", "-DSERVICE_PORT=${SERVICE_PORT}", "-DDB_JDBC=${DB_JDBC}", "-DDB_LOGIN=${DB_LOGIN}", "-DDB_PASSW=${DB_PASSW}", "-DUSER_SERVICE_API=${USER_SERVICE_API}", "-jar", "post-service.jar"]

EXPOSE ${SERVICE_PORT}
