FROM openjdk:11

WORKDIR /myapp

COPY ./ReadServers.java .
COPY ./servers.txt .

RUN javac ReadServers.java

CMD ["java" , "ReadServers"]