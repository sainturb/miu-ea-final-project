FROM adoptopenjdk/openjdk11
COPY /movie-service/target/movie-service-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "-Xms128m", "-Xmx256M",  "/app.jar"]