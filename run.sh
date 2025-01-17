#!/bin/bash

----------------------------------------

Check if Java is installed

----------------------------------------

if ! command -v java &> /dev/null; then
echo "Error: Java is not installed. Please install Java."
exit 1
fi

----------------------------------------

Check if Maven is installed

----------------------------------------

if ! command -v mvn &> /dev/null; then
echo "Error: Maven is not installed. Please install Maven."
exit 1
fi

----------------------------------------

Check if PostgreSQL is installed

----------------------------------------

if ! command -v psql &> /dev/null; then
echo "Error: PostgreSQL is not installed. Please install PostgreSQL."
exit 1
fi

----------------------------------------

Check required environment variables

----------------------------------------

if [ -z "$DB_NAME" ]; then
echo "Error: DB_NAME environment variable not set."
exit 1
fi

if [ -z "$DB_USERNAME" ]; then
echo "Error: DB_USERNAME environment variable not set."
exit 1
fi

if [ -z "$DB_PASSWORD" ]; then
echo "Error: DB_PASSWORD environment variable not set."
exit 1
fi

----------------------------------------

Create PostgreSQL database and user if they dont exist

----------------------------------------

echo "Checking PostgreSQL database and user..."
psql -U postgres -tc "SELECT 1 FROM pg_database WHERE datname = '$DB_NAME'" | grep -q 1 || psql -U postgres -c "CREATE DATABASE $DB_NAME;"
psql -U postgres -tc "SELECT 1 FROM pg_roles WHERE rolname = '$DB_USERNAME'" | grep -q 1 || psql -U postgres -c "CREATE USER $DB_USERNAME WITH PASSWORD '$DB_PASSWORD';"
psql -U postgres -c "GRANT ALL PRIVILEGES ON DATABASE $DB_NAME TO $DB_USERNAME;"

----------------------------------------

Build the project with Maven if not already built

----------------------------------------

PROJECT_DIR="$(pwd)"
JAR_NAME="dungeoncrawl.jar"
TARGET_DIR="$PROJECT_DIR/target"

if [ ! -f "$TARGET_DIR/$JAR_NAME" ]; then
echo "Building the project with Maven..."
mvn clean package
if [ $? -ne 0 ]; then
echo "Error: Maven build failed."
exit 1
fi
fi

----------------------------------------

Run the DungeonCrawl application

----------------------------------------

echo "Running DungeonCrawl with JavaFX and PostgreSQL..."
java -Ddatabase.name=$DB_NAME -Ddatabase.username=$DB_USERNAME -Ddatabase.password=$DB_PASSWORD -jar "$TARGET_DIR/$JAR_NAME"

