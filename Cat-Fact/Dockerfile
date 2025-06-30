FROM openjdk:17

WORKDIR /myapp

COPY ./CatFactFetcher.java .

RUN javac CatFactFetcher.java

CMD ["java" , "CatFactFetcher"]