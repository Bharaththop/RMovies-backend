
# Use an official Ubuntu as a base image
FROM ubuntu:20.04

# Install necessary packages and dependencies
RUN apt-get update && \
    apt-get install -y wget gnupg software-properties-common

# Add the AdoptOpenJDK repository and import the public key
RUN wget -qO - https://packages.adoptium.net/artifactory/api/gpg/key/public | apt-key add - && \
    add-apt-repository --yes https://packages.adoptium.net/artifactory/deb/

# Install JDK 17
RUN apt-get update && \
    apt-get install -y temurin-17-jdk

# Set the environment variable for JAVA_HOME
ENV JAVA_HOME=/usr/lib/jvm/temurin-17-jdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

# Verify installation
RUN java -version

# Add any additional commands you need for your application setup

# Example: copy your application code to the container
# COPY demo-0.0.1-SNAPSHOT.jar.jar /app/your-app.jar

# Example: specify the command to run your application
# CMD ["java", "-jar", "/app/your-app.jar"]

