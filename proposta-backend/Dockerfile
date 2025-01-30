FROM openjdk:17

COPY target/proposta-backend-0.0.1-SNAPSHOT.jar proposta-backend.jar

COPY wait-for-it.sh wait-for-it.sh

RUN chmod +x wait-for-it.sh

ENTRYPOINT ["./wait-for-it.sh", "rabbit-mq:5672", "--", "java", "-Duser.language=pt", "-Duser.country=BR", "-jar", "proposta-backend.jar"]