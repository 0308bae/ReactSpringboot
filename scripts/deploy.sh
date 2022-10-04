#!/bin/bash

echo "start docker-compose up: ubuntu"
sudo systemctl start docker
cd /home/ec2-user/github_action
sudo docker-compose up --build -d
