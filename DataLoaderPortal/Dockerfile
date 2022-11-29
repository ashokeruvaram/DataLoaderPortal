FROM openjdk:17
EXPOSE 8085
ADD target/data-load-docker.jar data-load-docker.jar
ENTRYPOINT ["java","-jar","/data-load-docker.jar"]