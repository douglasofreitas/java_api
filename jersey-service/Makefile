.PHONY: run in stop clean

build: 
	docker build -t "java_api" .

run:
	docker run -it -p 8080:8080 --rm --name java_api_test java_api /bin/bash

compose:
	docker-compose up --build -d build

compose-in:
	docker exec -i -t java-api-src /bin/bash

compose-stop:
	docker-compose stop

compose-clean:
	docker-compose down
