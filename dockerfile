FROM openjdk:8
VOLUME /tmp
ADD target/security-ms*.jar /appsecurity.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/appsecurity.jar"]