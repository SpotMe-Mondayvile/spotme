FROM openjdk:17
FROM maven:3.9.8-amazoncorretto-17


EXPOSE 8080
EXPOSE 3000
EXPOSE 5000

RUN apt install maven

COPY . .

RUN  mvn package -ntp -Dmaven.test.skip

CMD ["java","-jar target/spotme-rest-0.0.1-SNAPSHOT.jar"]




