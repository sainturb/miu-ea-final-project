#FROM openjdk:18-ea-11-jdk-alpine
#RUN apk --no-cache add curl
FROM adoptopenjdk:11-jre-hotspot-focal
WORKDIR /home/app
COPY /discovery-service/target/discovery-service-0.0.1-SNAPSHOT.jar /home/app/app.jar
ENTRYPOINT ["java", "-jar", "/home/app/app.jar"]