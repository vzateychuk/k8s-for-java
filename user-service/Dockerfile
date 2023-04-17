FROM amazoncorretto:11

MAINTAINER vzateychuk

COPY ./build/libs/user-service-0.0.1-SNAPSHOT.jar /app/user-service.jar
WORKDIR /app

CMD ["java", "-DSERVICE_PORT=${SERVICE_PORT}", "-DDB_JDBC=${DB_JDBC}", "-DDB_LOGIN=${DB_LOGIN}", "-DDB_PASSW=${DB_PASSW}", "-jar", "user-service.jar"]

EXPOSE ${SERVICE_PORT}
