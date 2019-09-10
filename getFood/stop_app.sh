#! /bin/bash
echo "Parando a aplicação"
docker stop app
echo "Removendo o container"
docker rm app
echo "Removendo a imagem"
docker rmi -f getfood/app

echo "Concluído."
