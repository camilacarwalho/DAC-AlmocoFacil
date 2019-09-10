#!/bin/bash
echo " "
echo "-------------------------------"
echo "Implantando o banco de dados..."
echo "-------------------------------"
echo " "
docker build -t getfood/bd ./postgres
docker run -p 5433:5432 --name bd -d getfood/bd
docker logs bd
echo "Aguarde..."
echo " "
sleep 5
echo "Concluído. Container do banco de dados implantando."
echo " "

