#!/bin/bash

java -Dquarkus.http.port=8081 -classpath /app/application.jar:/app/lib/* io.quarkus.runner.GeneratedMain
