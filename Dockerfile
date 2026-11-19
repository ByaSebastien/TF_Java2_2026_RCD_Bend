FROM maven:3.9.16-eclipse-temurin-25 AS build

WORKDIR /app

COPY ./pom.xml ./
COPY ./api/pom.xml ./api/pom.xml
COPY ./bll/pom.xml ./bll/pom.xml
COPY ./dal/pom.xml ./dal/pom.xml

RUN mvn dependency:go-offline

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-jdk-jammy

WORKDIR /app

COPY --from=build /app/api/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]