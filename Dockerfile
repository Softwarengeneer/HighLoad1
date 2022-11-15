FROM gradle:4.7.0-jdk8-alpine AS build
COPY --chown=gradle:gradle ./src /home/gradle/app/src
COPY --chown=gradle:gradle build.gradle.kts /home/gradle/app
COPY --chown=gradle:gradle settings.gradle.kts /home/gradle/app
WORKDIR /home/gradle/app
RUN gradle build --no-daemon

FROM openjdk:8-jre-slim as run
RUN mkdir /app
COPY --from=build /home/gradle/app/build/libs/*.jar /app/spring-boot-application.jar
ENTRYPOINT ["java", "-jar","/app/spring-boot-application.jar"]