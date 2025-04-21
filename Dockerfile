FROM amazoncorretto:21 as jdk
FROM gradle:8.9-jdk21 AS build

WORKDIR /app
COPY . .
RUN ./gradlew clean shadowJar

FROM amazoncorretto:21-alpine

WORKDIR /app
COPY .env /app/.env
COPY --from=build /app/build/libs/com.server-0.0.1.jar app.jar
EXPOSE 7000
CMD ["java", "-jar", "app.jar"]