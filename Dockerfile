# Use prebuilt Selenium + Chrome
FROM selenium/standalone-chrome:latest

# Set working directory
WORKDIR /app

# Switch to root to install Maven
USER root
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Switch back to seluser (default Selenium user)
USER seluser

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn -q -B -DskipTests dependency:go-offline

# Copy source code
COPY src ./src

# Run tests by default
CMD ["mvn", "-q", "-B", "test"]
