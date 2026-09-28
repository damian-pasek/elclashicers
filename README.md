# El Clashicers

## Overview

A full-stack web application for members of El Clashicers clan family from the game Clash Royale.

## Table of contents

1. [Technology Stack](#technology-stack)
2. [Installation](#installation)
3. [Default Credentials](#default-credentials)


## Technology Stack
- **Frontend:** React, TypeScript, Vite
- **Backend:** Java, Maven, Spring Boot
- **Database:** PostgreSQL
- **Deployment:** Docker

## Installation

### 1. Clone the repository
```bash
git clone https://github.com/damian-pasek/elclashicers.git
cd elclashicers
```

### 2. Docker setup
Make sure you have docker and docker compose installed on your system:

```bash
docker --version
docker compose version
```
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

### Starting the Database
Before running the database for the first time, create your local environment configuration file from the template by running the following command in the /database directory:
```bash
cd database

cp .env.example .env
```
Open the newly created .env file and adjust the database credentials to match your local setup. Then, start the PostgreSQL container using Docker Compose:

```bash
docker compose up -d
```

### 3. Backend Setup
Check if Java 25 is installed on your system:
```bash
java -version
```
- [Oracle JDK 25](https://www.oracle.com/pl/java/technologies/downloads/#java25)

Apache Maven 3+ is required to build the application. Verify maven installation by running:
```bash
mvn -v
```
[Apache Maven](https://maven.apache.org/install.html)

Next step is to install dependencies and start the backend server:

```bash
#navigate to backend directory from the root directory
cd backend

#install dependencies
mvn clean install

#start the backend server
mvn spring-boot:run
```

The backend server will be active at http://localhost:8080

### 4. Frontend Setup

Open new terminal window and navigate to frontend directory:

```bash
cd frontend

#Verify Node Package Manager installation:
npm -v
```
If npm is not installed, download Node.js from here ([Node.js](https://nodejs.org/en/download)), and it will automatically install npm along with it

Next step is to install all frontend packages and to start the Vite development server:

```bash
#install frontend packages
npm install

#start Vite development server
npm run dev
```
The application should start at http://localhost:5173/

### 5. Stopping the application
1. Pressing Ctrl+C in both terminal windows (backend, fronted) will stop the servers
2. In the root directory stop and remove the database container:
```bash
docker compose down
```
This will stop and remove the container, but the data will be preserved thanks to the mounted volume.

If you want to remove the database data completely (including the volume), you can run:
```bash
docker compose down -v
```