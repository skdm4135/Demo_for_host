# Stage 1: Build the application
# Use a JDK image that includes Maven (change to openjdk-21 or openjdk-17 as needed)
FROM maven:3.9-eclipse-temurin-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies first (for better caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of your source code
COPY src ./src

# Build the .jar file
RUN mvn clean package -DskipTests

# -----------------------------------------------------

# Stage 2: Create the final, smaller runtime image
# Use a lightweight JRE-only image (must match your JDK version)
FROM eclipse-temurin:17-jre-focal

WORKDIR /app

# Copy the built .jar file from the 'build' stage
COPY --from=build /app/target/*.jar app.jar

# Spring Boot's default port is 8080. We expose it.
EXPOSE 8080

# This is the command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]