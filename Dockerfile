FROM adoptopenjdk/openjdk8-openj9

ADD target/lib /app/lib
#ADD quarkus-libs.jar /app/
ADD script.sh /app/
ADD start-quarkus.sh /app/
ADD openwhisk-web-action-http-proxy /app/

ENV PROXY_PORT 8081
ENV PROXY_ALIVE_DELAY 1000
ENV APP_SERVER_CMD /app/start-quarkus.sh
EXPOSE 8080

WORKDIR /app
CMD ./script.sh
