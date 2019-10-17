#!/usr/bin/env bash

docker run -i --rm -p 8090:8080 --net quarkusjpademo_default --link jpa-library quarkus/librarian-jvm
