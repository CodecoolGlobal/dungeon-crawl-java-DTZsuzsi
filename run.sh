#!/bin/bash

if ! command -v java &> /dev/null
then
    echo "Error: Java is not installed. Please install Java."
    exit 1
fi

if [ -z "$DB_NAME" ]; then
  echo "Error: DB_NAME environment variable not set."
  exit 1
fi

if [ -z "$DB_USERNAME" ]; then
  echo "Error: DB_USERNAME environment variable not set."
  exit 1
fi

if [ -z "$DB_PASSWORD" ]; then
  echo "Error: DB:PASSWORD environment variable not set."
  exit 1
fi

PROJECT_DIR="$(pwd)"
JAR_NAME="dungeoncrawl.jar"
TARGET_DIR="$PROJECT_DIR/target"

if [ ! -f "$TARGET_DIR/$JAR_NAME" ]; then
  echo "Fat JAR file not found. Please build the project first with Maven."
  exit 1
fi

echo "Running DungeonCrawl with JavaFX and PostgreSQL..."

java -Ddatabase.name=$DB_NAME \
     -Ddatabase.username=$DB_USERNAME \
     -Ddatabase.password=$DB_PASSWORD \
     -jar "$TARGET_DIR/$JAR_NAME"
