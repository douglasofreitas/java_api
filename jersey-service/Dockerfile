FROM java:8
MAINTAINER Douglas Freitas "douglasofreitas@gmail.com"

RUN mkdir /usr/src/myapp
COPY ./target/simple-service-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/src/myapp

EXPOSE 8080
WORKDIR /usr/src/myapp
CMD ["java", "-jar", "simple-service-1.0-SNAPSHOT-jar-with-dependencies.jar"]
