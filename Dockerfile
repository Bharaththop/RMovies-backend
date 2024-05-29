# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the application and generate the JAR file
RUN mvn package -DskipTests

# Stage 2: Create a lightweight image with JDK 17 to run the JAR
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar ./app.jar

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
