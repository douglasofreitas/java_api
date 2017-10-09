.PHONY: run in stop clean

run:
	docker-compose up --build -d build

rundev:
	docker-compose up --build -d dev

in:
	docker exec -i -t java-api-src /bin/bash

stop:
	docker-compose stop

clean:
	docker-compose down
