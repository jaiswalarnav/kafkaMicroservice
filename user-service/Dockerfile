FROM openjdk:11
LABEL maintainer="arnavjaiswal"
EXPOSE 9001
ADD target/user-service-0.0.1-SNAPSHOT.jar user-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/user-service-0.0.1-SNAPSHOT.jar"]