FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD /target/ProjetDevops-1.0.jar  ProjetDevops-1.0.jar
ENTRYPOINT ["java", "-jar", "ProjetDevops-1.0.jar"]
