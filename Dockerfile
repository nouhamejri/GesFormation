FROM maven:3.8.1-jdk-8
#WORKDIR /gesF-AJ
ADD target/GesF.jar GesF.jar
#COPY . .
ENTRYPOINT ["java", "-jar", "GesF.jar"]
#CMD mvn clean install
#CMD mvn spring-boot:run
EXPOSE 8085