#!/bin/bash
echo " "
echo "-------------------------------"
echo "Parando o banco de dados..."
echo "-------------------------------"
echo " "
docker stop bd
echo " "
echo "-------------------------------"
echo "Removendo o container do banco de dados..."
echo "-------------------------------"
echo " "
docker rm bd
echo " "
echo "-------------------------------"
echo "Excluíndo a imagem do banco de dados..."
echo "-------------------------------"
echo " "
docker rmi -f getfood/bd
echo " "
echo "Concluído."
sleep 5
echo " "