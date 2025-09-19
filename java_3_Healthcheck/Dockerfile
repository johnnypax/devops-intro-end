# Stage 1: Build
FROM maven:3.9.11-eclipse-temurin-17 AS build
WORKDIR /out
COPY . .
RUN mvn -q -DskipTests package

# Stage 2: Runtime
FROM eclipse-temurin:17-jre AS runtime
WORKDIR /app
COPY --from=build /out/target/*.jar executable.jar

# Installo cURL perché mi server per fare Healthcheck
USER root
RUN apt-get update \
	&& apt-get install -y --no-install-recommends curl
	
HEALTHCHECK --start-period=20s --retries=3 --interval=10s --timeout=2s \
	CMD curl -fsS http://localhost:8081/health || exit 1

EXPOSE 8081
#ENTRYPOINT ["java", "-jar", "executable.jar", "--spring.profiles.active=dev"]
ENTRYPOINT ["java", "-jar", "executable.jar"]