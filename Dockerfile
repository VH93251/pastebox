FROM maven:3.8.6-eclipse-temurin-17 AS build
VOLUME /tmp
COPY src /pastebox/src
COPY pom.xml /pastebox
RUN mvn -f /pastebox/pom.xml clean package

FROM eclipse-temurin:17_35-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY --from=build /pastebox/target/pastebox-0.0.1-SNAPSHOT.jar /usr/local/lib/pastebox.jar
EXPOSE 8075
ENTRYPOINT ["java","-Dspring.profiles.active","-jar","/usr/local/lib/pastebox.jar"]

