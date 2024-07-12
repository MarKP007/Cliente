# Use a Maven image to build the project
FROM maven:3.8.3-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and download the dependencies
COPY pom.xml .

# Copiar wait-for-it.sh en la imagen
COPY wait-for-it.sh /usr/local/bin/wait-for-it.sh
RUN chmod +x /usr/local/bin/wait-for-it.sh

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use a base image with Java installed to run the application
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/Cliente-0.0.1-SNAPSHOT.jar /app/Cliente.jar

# Expose the port that your Spring Boot application uses
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "Cliente.jar"]