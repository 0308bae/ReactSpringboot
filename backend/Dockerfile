FROM gradle:jdk18

ENV VERSION 0.0.0
ENV PROJECTNAME demo

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew build

EXPOSE 8080

WORKDIR /app/build/libs

CMD ["java", "-jar", "./demo-0.0.0.jar"]