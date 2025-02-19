FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
COPY db/migration/customer /app/db/migration/customer
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]