FROM openjdk:alpine

WORKDIR "/app"

ADD "build/libs/*.jar" service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","-Xms256m", "-Xmx512m","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=k8s","service.jar"]