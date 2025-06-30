FROM openjdk:17

WORKDIR /myapp

COPY . .

# Use Linux-style classpath (with `:`)
RUN javac -cp ".:mysql-connector-j-9.3.0.jar" MySQLNameApp.java

# Use Linux-style classpath (with `:`) here too
CMD ["java", "-cp", ".:mysql-connector-j-9.3.0.jar", "MySQLNameApp"]
