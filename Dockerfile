FROM openjdk:17-jdk-alpine
MAINTAINER DOCKER
COPY target/liquibase-0.0.1-SNAPSHOT.jar liquibase-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/liquibase-0.0.1-SNAPSHOT.jar"]