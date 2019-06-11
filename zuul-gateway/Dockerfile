FROM openjdk:11.0.3-jdk-stretch
ADD ./target/zuul-gateway-0.0.1-SNAPSHOT.jar /app/microservices/zuul-gateway-0.0.1-SNAPSHOT.jar
WORKDIR /app/microservices
ENTRYPOINT ["java","-jar","zuul-gateway-0.0.1-SNAPSHOT.jar"]