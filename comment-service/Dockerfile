FROM adoptopenjdk/openjdk11
COPY /comment-service/target/comment-service-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "-Xms128m", "-Xmx256M", "/app.jar"]