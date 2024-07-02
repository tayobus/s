FROM ubuntu:latest
LABEL authors="chaeb"

ENTRYPOINT ["top", "-b"]

# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /docker-java-app

# Copy the application's JAR file to the container
COPY build/libs/ezSpring-0.0.1-SNAPSHOT.jar /docker-java-app/myapp.jar

# Make port 8080 available to the world outside this container
EXPOSE 5000

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/docker-java-app/myapp.jar"]
