# API hosting on render.com

FROM ubuntu:latest AS build
RUN apt-get update && apt-get install -y openjdk-17-jdk wget unzip && rm -rf /var/lib/apt/lists/*

COPY . .

RUN ./gradlew clean build -x test

EXPOSE 8080
ENTRYPOINT ["./gradlew", "bootRun"]