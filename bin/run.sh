docker system prune -f
mvn clean install
docker-compose -f src/main/docker/docker-compose.yml up