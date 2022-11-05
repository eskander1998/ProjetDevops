FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:adminadmin -o ProjetDevops-1.0.jar "http//192.168.43.6:8081/repository/maven-releases/com/esprit/examen/ProjetDevops/1.0/ProjetDevops-1.0.jar" -L
ENTRYPOINT ["java","-jar","/ProjetDevops-1.0.jar"]
EXPOSE 8089