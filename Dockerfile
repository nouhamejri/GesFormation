FROM maven:3.8.1-jdk-8
EXPOSE 8084
WORKDIR /GestF
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run