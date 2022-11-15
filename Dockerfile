FROM gradle:7.5.1-jdk17-alpine AS build
COPY --chown=gradle:gradle ./src /home/gradle/app/src
COPY --chown=gradle:gradle build.gradle.kts /home/gradle/app
COPY --chown=gradle:gradle settings.gradle.kts /home/gradle/app
WORKDIR /home/gradle/app
RUN gradle build --no-daemon

FROM amazoncorretto:17.0.5 as run
RUN mkdir /app
COPY --from=build /home/gradle/app/build/libs/*.jar /app/
ENTRYPOINT ["java", "-jar","/app/HighLoad1-0.0.1-SNAPSHOT.jar"]