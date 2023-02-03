FROM openjdk:11
LABEL maintainer="arnavjaiswal"
EXPOSE 9002
ADD target/contact-service-0.0.1-SNAPSHOT.jar contact-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/contact-service-0.0.1-SNAPSHOT.jar"]