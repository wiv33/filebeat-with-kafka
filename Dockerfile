FROM hirokimatsumoto/alpine-openjdk-11

MAINTAINER PS

VOLUME /var/log/
EXPOSE 8090

# --build-arg build/libs/*.jar
ARG JAR_FILE
#ARG APP=app.jar
COPY ${JAR_FILE} app.jar

#"-Djava.security.egd=file:/dev/./urandom",
#"-Dspring.profiles.active=prod",
ENTRYPOINT ["java", "-jar", "/app.jar"]