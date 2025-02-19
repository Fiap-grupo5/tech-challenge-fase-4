FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
COPY db/migration/product /app/db/migration/product
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
