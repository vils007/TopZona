FROM openjdk:17-oracle
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=/build/libs/TopZona-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]