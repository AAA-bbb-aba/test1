FROM docker.m.daocloud.io/library/eclipse-temurin:8-jdk-alpine
LABEL maintainer="hjt"
WORKDIR /app
COPY target/study-1.0-SNAPSHOT.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
