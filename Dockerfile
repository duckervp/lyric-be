FROM eclipse-temurin:21-jre-alpine
COPY target/lyric-0.0.1-SNAPSHOT.jar lyric-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/lyric-0.0.1-SNAPSHOT.jar"]