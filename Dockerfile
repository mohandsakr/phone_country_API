FROM openjdk:11 
COPY  ./target/phone_countryAPI-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "phone_countryAPI-0.0.1-SNAPSHOT.jar"]

 