FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY ./target/course-service-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java","-jar","course-service-0.0.1-SNAPSHOT.jar"]