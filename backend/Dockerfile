FROM gradle:jdk18

WORKDIR /app

COPY . .

EXPOSE 8080

WORKDIR /app/build/libs

CMD ["java", "-jar", "./demo-0.0.0.jar"]
