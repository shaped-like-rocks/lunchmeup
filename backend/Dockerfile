FROM openjdk:8-jre-alpine

EXPOSE 8080
# install spring-boot artifact
VOLUME /tmp
ADD /build/libs/lunchmeup.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]