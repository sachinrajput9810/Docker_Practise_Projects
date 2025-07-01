FROM openjdk:17-slim

# Install netcat to wait for MySQL
RUN apt-get update && apt-get install -y netcat

WORKDIR /myapp

COPY . .

# Compile the Java program
RUN javac -cp ".:mysql-connector-j-9.3.0.jar" MySQLNameApp.java

# Make the wait script executable
RUN chmod +x wait-for-mysql.sh

# Run wait script before the Java app
CMD ["sh", "-c", "./wait-for-mysql.sh && java -cp .:mysql-connector-j-9.3.0.jar MySQLNameApp"]
