# dungeon-crawl

DungeonCrawl is a JavaFX-based, rougelike, tile-based game that connects to a PostgreSQL database. This README provides instructions for setting up the project, building it, and running it on your local machine using Maven.


Contributors:
Oláhné Klár Erika
dr. Ditrói-Tóth Zsuzsa

Git repository:  https://github.com/CodecoolGlobal/dungeon-crawl-java-DTZsuzsi.git


Prerequisites

Before running the project, ensure you have the following software installed on your system:

Java (JDK 8 or above)
Maven (for building the project)
PostgreSQL (for the database connection)
Install Java and Maven
To verify that Java and Maven are installed, run the following commands:

java -version
mvn -v
If Java or Maven is not installed, download and install them:

Install Java: https://www.oracle.com/java/technologies/downloads/#java11?er=221886
Install Maven: https://maven.apache.org/install.html
Set Up PostgreSQL Database: https://www.postgresql.org/download/
Ensure you have a PostgreSQL instance running. If you don't have PostgreSQL installed, follow the installation instructions for your platform:
PostgreSQL Installation Guide

Create a database for the game. You can do this by running the following commands in your PostgreSQL shell:
CREATE DATABASE dungeoncrawl;
CREATE USER yourusername WITH PASSWORD 'yourpassword';
GRANT ALL PRIVILEGES ON DATABASE dungeoncrawl TO yourusername;
Set the connection details in the environment variables that will be used when running the project.
Project Setup

1. Clone the Project
   Clone this project to your local machine using Git:

git clone https://github.com/yourusername/dungeoncrawl.git
cd dungeoncrawl
2. Set Environment Variables
   You need to set the following environment variables for PostgreSQL:

export DB_NAME="dungeoncrawl"
export DB_USERNAME="yourusername"
export DB_PASSWORD="yourpassword"
Make sure to replace the values with the actual details for your PostgreSQL database.

3. Build the Project with Maven
   Run the following command to build the project and create a fat JAR (which includes all dependencies):

mvn clean package

This command will generate a JAR file called dungeoncrawl.jar in the target/ directory.

4. Run the Application
   Once the JAR file is built, you can run the application using the provided run.sh script:

chmod +x run.sh
./run.sh

The script will:

Verify that Java and Maven are installed.
Check that the necessary environment variables for the PostgreSQL connection are set.
Build the project using Maven if it hasn't been built yet.
Run the fat JAR with the necessary database connection parameters.
Troubleshooting

1. Maven Dependency Issues
   If you encounter issues with Maven not picking up the correct dependencies or versions, you can force Maven to update its local cache and download the latest dependencies by running:

mvn clean install -U
If the problem persists, try deleting the cached dependencies from your local Maven repository (usually located at ~/.m2/repository) and re-run the mvn clean install -U command.

2. Missing or Outdated Dependencies
   If a dependency version is not recognized, you can specify the correct version of the dependency in your pom.xml file. For example, to include JavaFX:

<dependencies>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>17.0.2</version>
    </dependency>
</dependencies>
Run mvn clean install -U to update the dependencies and re-build the project.

Notes

JavaFX Support: This project requires JavaFX 11 or higher. If you're using a version of Java 8, JavaFX will be bundled with the JDK. If using Java 11 or later, you'll need to ensure JavaFX is included as a dependency in the pom.xml.
Database Setup: Ensure PostgreSQL is running and accessible, and that you have created the necessary database and user with the correct permissions.



