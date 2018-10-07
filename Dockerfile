FROM openjdk:11-jre

ARG JAR_FILE
ENTRYPOINT ["/usr/bin/java", "-Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector", "-jar", "/usr/share/app/starter-service.jar"]

ADD target/${JAR_FILE} /usr/share/app/starter-service.jar
