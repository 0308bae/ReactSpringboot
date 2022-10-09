#!/bin/bash

IS_DB_UP=$(docker ps -q -f name=nginx)
if [ -z "$IS_DB_UP" ]; then
    echo "init up"
    docker-compose -f docker-compose.yaml up --build -d
    exit
fi

IS_BLUE_UP=$(docker ps -q -f name=backend-blue)

if [ -z "$IS_BLUE_UP" ]; then
    echo "blue up"
    docker-compose -f docker-compose-blue.yaml up --build -d
    BEFORE_COMPOSE_COLOR="green"
    AFTER_COMPOSE_COLOR="blue"
else
    echo "green up"
    docker-compose -f docker-compose-green.yaml up --build -d
    BEFORE_COMPOSE_COLOR="blue"
    AFTER_COMPOSE_COLOR="green"
fi
 
echo "Load complete. Start switching after 60 sec"
sleep 60

IS_EXIST_AFTER=$(docker ps | grep backend-${AFTER_COMPOSE_COLOR})
if [ -n "$IS_EXIST_AFTER" ]; then
    docker exec -it nginx cp /etc/nginx/conf.d/${AFTER_COMPOSE_COLOR}.conf /etc/nginx/conf.d/default.conf
    docker exec -it nginx nginx -s reload
    docker-compose -f docker-compose-${BEFORE_COMPOSE_COLOR}.yaml down
    echo "$BEFORE_COMPOSE_COLOR down"
fi
