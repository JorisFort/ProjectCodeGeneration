# API hosting on render.com

FROM ubuntu:latest AS build
RUN apt-get update && apt-get install -y openjdk-17-jdk wget unzip && rm -rf /var/lib/apt/lists/*

# Install Gradle
RUN wget https://services.gradle.org/distributions/gradle-8.5-bin.zip -P /tmp \
    && unzip -d /opt/gradle /tmp/gradle-8.5-bin.zip \
    && rm /tmp/gradle-8.5-bin.zip
ENV PATH=/opt/gradle/gradle-8.5/bin:$PATH

COPY . .

RUN gradle wrapper
RUN ./gradlew clean build -x test

EXPOSE 8080
ENTRYPOINT ["./gradlew", "bootRun"]