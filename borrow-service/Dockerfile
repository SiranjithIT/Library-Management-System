FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/borrow-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","app.jar"]
