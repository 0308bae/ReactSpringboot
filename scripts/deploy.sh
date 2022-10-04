#!/bin/bash

echo "start docker-compose up: ubuntu"
sudo systemctl start docker
sudo docker-compose up --build -d
