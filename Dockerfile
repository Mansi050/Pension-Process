FROM openjdk:17
EXPOSE 8090
ADD target/processservice.jar processservice.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar processservice.jar"]
