FROM maven:3.8.4-openjdk-11 as build

RUN git clone https://github.com/seleniumwebproject/walletbox.git wp

WORKDIR wp

RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk11

COPY --from=build wp/target/walletbox-dev.jar .

COPY ./images ./images

EXPOSE 8080

ENTRYPOINT java -Djavax.net.ssl.trustStore="trustStore/cacerts" -jar walletbox-dev.jar

