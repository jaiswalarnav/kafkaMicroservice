FROM openjdk:11
LABEL maintainer="arnavjaiswal"
EXPOSE 8761
ADD target/e-server-0.0.1-SNAPSHOT.jar e-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/e-server-0.0.1-SNAPSHOT.jar"]