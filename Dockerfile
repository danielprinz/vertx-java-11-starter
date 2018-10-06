FROM openjdk:11-jre

ARG JAR_FILE
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/app/starter-service.jar"]

ADD target/${JAR_FILE} /usr/share/app/starter-service.jar
