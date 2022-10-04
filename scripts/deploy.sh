#!/bin/bash
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)
docker rmi $(docker images -q)
echo "start docker-compose up: ubuntu"
sudo systemctl start docker
cd /home/ec2-user/github_action
sudo docker-compose up --build -d
