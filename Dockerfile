FROM adoptopenjdk:15-jre-hotspot

ADD target/recepti-service.jar recepti-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "recepti-service.jar"]