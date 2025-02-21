FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
COPY db/migration/order /app/db/migration/order
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
