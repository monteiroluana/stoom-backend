FROM openjdk:8-jdk-alpine
MAINTAINER monteiroluana
COPY target/stoom-0.0.1-SNAPSHOT.jar stoom-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/stoom-0.0.1-SNAPSHOT.jar"]