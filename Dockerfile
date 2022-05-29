FROM java:8
EXPOSE 8091
COPY target/GesF-1.0.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
