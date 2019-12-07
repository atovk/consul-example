FROM lwieske/java-8:jdk-8u202-slim
VOLUME /tmp
ADD *.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]