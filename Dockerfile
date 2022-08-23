FROM openjdk:17
EXPOSE 8090
ADD target/ProcessPension-0.0.1-SNAPSHOT.jar ProcessPension-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar ProcessPension-0.0.1-SNAPSHOT.jar"]
