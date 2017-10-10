FROM maven:3.5.0-jdk-8
MAINTAINER Douglas Freitas "douglasofreitas@gmail.com"

RUN mkdir /usr/src/myapp
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp

EXPOSE 8080
WORKDIR /usr/src/myapp
CMD ["mvn", "exec:java"]