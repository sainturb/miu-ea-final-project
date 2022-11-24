FROM openjdk:18-ea-11-jdk-alpine
RUN apk --no-cache add curl
WORKDIR /home/app
COPY /config-service/target/config-service-0.0.1-SNAPSHOT.jar /home/app/app.jar
ENTRYPOINT ["java", "-jar", "-Xms128m", "-Xmx256M", "/home/app/app.jar"]