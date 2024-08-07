FROM openjdk:17-alpine
WORKDIR /app
COPY target/*.jar hexagonale.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/hexagonale.jar"]