FROM maven:3.8.1-jdk-8
#WORKDIR /gesF-AJ
ADD target/GesFapp.jar GesFapp.jar
EXPOSE 8085
#COPY . .
ENTRYPOINT ["java", "-jar", "GesFapp.jar"]
#CMD mvn clean install
#CMD mvn spring-boot:run
