#! /bin/bash

echo "Parando o banco de dados"
docker stop bd
echo "Removendo o container"
docker rm bd
echo "Removendo a imagem"
docker rmi -f getfood/bd

echo "Concluído."
