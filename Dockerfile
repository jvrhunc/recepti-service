FROM maven:3.6.3-openjdk-15 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM adoptopenjdk:15-jre-hotspot
COPY --from=build /home/app/target/recepti-service.jar /usr/local/lib/demo.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]