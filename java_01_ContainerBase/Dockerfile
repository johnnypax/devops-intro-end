# Single Stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY /target/*.jar executable.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "executable.jar"]