# Stage 1: Build
FROM maven:3.9.11-eclipse-temurin-17 AS build
WORKDIR /out
COPY . .
RUN mvn -q -DskipTests package

# Stage 2: Runtime
FROM eclipse-temurin:17-jre AS runtime
WORKDIR /app
COPY --from=build /out/target/*.jar executable.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "executable.jar"]