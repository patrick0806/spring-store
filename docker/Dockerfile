FROM maven:3-openjdk-17-slim as build
WORKDIR /app
COPY ../ .
RUN mvn clean package

FROM openjdk:17-jdk-slim as runtime
COPY --from=build /app/target/*.jar /spring-store.jar
CMD ["java", "-jar", "/spring-store.jar"]