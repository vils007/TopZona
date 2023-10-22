FROM gradle:8.4-focal as build

WORKDIR /workspase

COPY src ./src
COPY build.gradle ./build.gradle
COPY gradle.properties ./gradle.properties

RUN gradle clean build -x test

FROM bellsoft/liberica-openjdk-debian:21

RUN adduser --system spring-boot && addgroup --system spring-boot && adduser spring-boot spring-boot
USER spring-boot
#WORKDIR /app
VOLUME /tmp
EXPOSE 8080
COPY --from=build /workspase/build/libs/workspase-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java","-jar","/app.jar"]