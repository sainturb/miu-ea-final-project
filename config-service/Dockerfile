FROM adoptopenjdk/openjdk11
WORKDIR /home/app
COPY /config-service/target/config-service-0.0.1-SNAPSHOT.jar /home/app/app.jar
ENTRYPOINT ["java", "-jar", "/home/app/app.jar"]