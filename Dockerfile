FROM openjdk:18

WORKDIR /app

COPY build/libs/ProjetWebBook-1.2-SNAPSHOT.jar .

EXPOSE 8080

RUN chmod +x ProjetWebBook-1.2-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","ProjetWebBook-1.2-SNAPSHOT.jar"]