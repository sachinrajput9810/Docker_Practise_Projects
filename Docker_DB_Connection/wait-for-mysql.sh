#!/bin/sh

# Wait until MySQL is accepting connections on port 3306
echo "Waiting for MySQL to be ready..."

while ! nc -z mysqldb 3306; do
  sleep 1
done

echo "MySQL is up - starting app"
java -cp ".:mysql-connector-j-9.3.0.jar" MySQLNameApp
