FROM maven:3.8.1-jdk-8
WORKDIR /gesF-AJ
#ADD target/GesF-1.5.jar GesF-1.5.jar
COPY . .
#ENTRYPOINT ["java", "-jar", "GesF-1.5.jar"]
CMD mvn clean install
CMD mvn spring-boot:run
#EXPOSE 8084