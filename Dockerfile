# Use Maven with JDK 21 to build the app
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ /app/src
RUN mvn clean package

# Use JDK 21 to run the app
FROM eclipse-temurin:21-jre
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/demo.jar"]