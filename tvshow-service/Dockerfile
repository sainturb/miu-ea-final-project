FROM adoptopenjdk:11-jre-hotspot-focal
COPY /tvshow-service/target/tvshow-service-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "-Xms128m", "-Xmx256M",  "/app.jar"]