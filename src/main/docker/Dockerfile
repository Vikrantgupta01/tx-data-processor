FROM openjdk:8-jre
WORKDIR /app
CMD mkdir -p logs
VOLUME ["/app"]
COPY maven/app.jar app.jar
COPY maven/start.sh start.sh
COPY maven/wait-for-it.sh wait-for-it.sh
RUN sh -c 'touch app.jar'
ENTRYPOINT ["./start.sh"]
