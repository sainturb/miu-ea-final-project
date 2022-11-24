FROM adoptopenjdk:11-jre-hotspot-focal
WORKDIR /home/app
COPY /gateway-service/target/gateway-service-0.0.1-SNAPSHOT.jar /home/app/app.jar
ENTRYPOINT ["java", "-jar", "/home/app/app.jar"]