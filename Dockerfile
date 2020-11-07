FROM openjdk:15-jdk-alpine
WORKDIR /todo-api
COPY . .
#RUN mvn -B clean package -DskipTests
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod","target/todo-0.0.1-SNAPSHOT.jar"]