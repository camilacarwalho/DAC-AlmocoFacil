#!/bin/bash
echo " "
echo "-------------------------------"
echo "Parando a aplicação..."
echo "-------------------------------"
echo " "
docker stop app
echo " "
echo "-------------------------------"
echo "Removendo o container da aplicação..."
echo "-------------------------------"
echo " "
docker rm app
echo " "
echo "-------------------------------"
echo "Excluíndo a imagem da aplicação..."
echo "-------------------------------"
echo " "
docker rmi -f getfood/app
echo " "
echo "Concluído."
sleep 5
echo " "