.PHONY: package

package:
	clear && ./mvnw package

.PHONY: run

run:
	clear && mvn spring-boot:run

.PHONY: build

build:
	clear && docker-compose --env-file "/mnt/ext/git/github/public/mongo_spring/.env" build

.PHONY: up

up:
	clear && docker-compose --env-file "/mnt/ext/git/github/public/mongo_spring/.env" up -d

.PHONY: down

down:
	docker-compose down

.PHONY: all

all:
	docker-compose down && cd mongodb/scripts/ && sh remove-folder-data.sh && cd ../../ && ./mvnw package && docker-compose --env-file "/mnt/ext/git/github/public/mongo_spring/.env" build && docker-compose --env-file "/mnt/ext/git/github/public/mongo_spring/.env" up -d
