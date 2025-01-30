FROM openjdk:17

WORKDIR /app

COPY target/proposta-backend-0.0.1-SNAPSHOT.jar proposta-backend.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Duser.language=pt", "-Duser.country=BR", "-jar", "proposta-backend.jar"]