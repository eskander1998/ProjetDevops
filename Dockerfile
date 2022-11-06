FROM maven:3.8.2-jdk-8
ADD target/ProjetDevops-1.0.jar ProjetDevops.jar
ENTRYPOINT ["java","-jar","/ProjetDevops.jar"]