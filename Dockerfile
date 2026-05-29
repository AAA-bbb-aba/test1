# 第一阶段：编译
FROM docker.m.daocloud.io/library/maven:3.8.6-openjdk-8-slim AS builder
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests -B

# 第二阶段：运行
FROM docker.m.daocloud.io/library/eclipse-temurin:8-jdk-alpine
LABEL maintainer="hjt"
WORKDIR /app
COPY --from=builder /build/target/*.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
