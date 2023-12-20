FROM openjdk:18

WORKDIR /app

COPY build/libs/ProjetWebBook-2.0-SNAPSHOT.jar .

EXPOSE 8080

RUN chmod +x ProjetWebBook-2.0-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","ProjetWebBook-2.0-SNAPSHOT.jar"]