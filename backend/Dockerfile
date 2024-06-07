# API hosting on render.com

FROM ubuntu:latest AS build
RUN apt-get update && apt-get install -y openjdk-17-jdk wget unzip && rm -rf /var/lib/apt/lists/*

# Install Gradle
RUN wget https://services.gradle.org/distributions/gradle-8.8-bin.zip -P /tmp \
    && unzip -d /opt/gradle /tmp/gradle-8.8-bin.zip \
    && rm /tmp/gradle-8.8-bin.zip
ENV PATH=/opt/gradle/gradle-8.8/bin:$PATH

# Set working directory
WORKDIR /app

# Copy only necessary files
COPY backend /app

# Generate Gradle wrapper
RUN gradle wrapper

# Disable the Gradle daemon
RUN echo "org.gradle.daemon=false" >> /app/gradle.properties

# Build the project
RUN ./gradlew clean build -x test

# Expose the application port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["./gradlew", "bootRun"]
