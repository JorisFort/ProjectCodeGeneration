# API hosting on render.com

FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk wget unzip -y

# Install Gradle
RUN wget https://services.gradle.org/distributions/gradle-8.8-bin.zip -P /tmp \
    && unzip -d /opt/gradle /tmp/gradle-8.8-bin.zip \
    && rm /tmp/gradle-8.8-bin.zip
ENV PATH=/opt/gradle/gradle-8.8/bin:$PATH

COPY . .
RUN gradle wrapper
RUN ./gradlew clean build -x test

EXPOSE 8080
ENTRYPOINT ["./gradlew", "bootRun"]