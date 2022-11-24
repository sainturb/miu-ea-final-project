mvn clean install package

docker build -t movie-service -f ./movie-service/Dockerfile .
docker build -t tvshow-service -f ./tvshow-service/Dockerfile .
docker build -t rating-service -f ./rating-service/Dockerfile .
docker build -t comment-service -f ./comment-service/Dockerfile .
docker build -t user-service -f  ./user-service/Dockerfile .
docker build -t discovery-service -f  ./discovery-service/Dockerfile .
docker build -t gateway-service -f  ./gateway-service/Dockerfile .
docker build -t config-service -f  ./config-service/Dockerfile .