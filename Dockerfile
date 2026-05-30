# ===============================
# 第1阶段：编译源码 → 生成 JAR 包
# 用带 Maven 的镜像（几百MB），编译完就不要了
# ===============================
FROM docker.m.daocloud.io/library/maven:3.8.6-openjdk-8-slim AS builder
WORKDIR /build
COPY pom.xml .
# 先复制依赖配置（pom.xml 不经常变，缓存友好）
RUN mvn dependency:go-offline -B
    # 提前下载依赖，源码没改就不用重新下
COPY src ./src
# 再复制源代码
RUN mvn clean package -DskipTests -B
    # 编译打包 → target/study-1.0-SNAPSHOT.jar

# ===============================
# 第2阶段：运行环境
# 换一个干净的小 JDK 镜像（几十MB），只放 JAR
# ===============================
FROM docker.m.daocloud.io/library/eclipse-temurin:8-jdk-alpine
LABEL maintainer="hjt"
WORKDIR /app
COPY --from=builder /build/target/*.jar app.jar
# 从第1阶段把 JAR 拿过来
EXPOSE 8091
# 声明容器内部服务端口
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
# 容器启动时执行 java -jar
