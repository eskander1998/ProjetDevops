FROM openjdk:8-jdk-alpine
EXPOSE 8040
RUN apk --no-cache add curl
RUN curl -u admin:fourat -o ProjetDevops-1.0.jar "http://192.168.1.106:8081/repository/maven-releases/com/esprit/examen/ProjetDevops/1.0/ProjetDevops-1.0.jar" -L
ENTRYPOINT ["java","-jar","/ProjetDevops-1.0.jar"]
