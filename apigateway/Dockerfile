FROM openjdk:11
LABEL maintainer="arnavjaiswal"
EXPOSE 8999
ADD target/apigateway-0.0.1-SNAPSHOT.jar apigateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/apigateway-0.0.1-SNAPSHOT.jar"]