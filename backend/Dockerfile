FROM gradle:jdk18

WORKDIR /app

COPY . .

RUN sed -i -e 's/\r$//' ./gradlew

RUN chmod +x ./gradlew

RUN ./gradlew build

EXPOSE 8080

WORKDIR /app/build/libs

CMD ["java", "-jar", "./demo-0.0.0.jar"]