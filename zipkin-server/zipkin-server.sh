#!/usr/bin/env bash

docker run -d -p 9411:9411 --name zipkin-server openzipkin/zipkin
