FROM maven:3.8.1 as build
COPY /src /app/src
COPY /pom.xml /app
RUN mvn -f /app/pom.xml clean install

FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar backend1.jar
