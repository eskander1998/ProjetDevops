FROM openjdk:8
EXPOSE 8089
ADD target/ProjetDevops1.0.jar ProjetDevops1.0.jar
ENTRYPOINT ["java", "-jar", "/ProjetDevops1.0.jar"]