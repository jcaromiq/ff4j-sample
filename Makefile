.PHONY: all build docker-up docker-down docker-up-ek

all: build docker-down docker-up

build:
	./gradlew build

docker-up:
	docker-compose up -d

docker-down:
	docker-compose down