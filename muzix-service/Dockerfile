FROM openjdk:11.0.3-jdk-stretch
ADD ./target/muzix-service-0.0.1-SNAPSHOT.jar /app/microservices/muzix-service-0.0.1-SNAPSHOT.jar
WORKDIR /app/microservices
ENTRYPOINT ["java","-jar","muzix-service-0.0.1-SNAPSHOT.jar"]