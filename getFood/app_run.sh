#!/bin/bash
echo " "
echo "-------------------------------"
echo "Contruíndo a aplicação..."
echo "-------------------------------"
echo " "
mvn clean install
cd shared && mvn clean package && cd ..
chmod -R 777 ./shared/target
cd app && mvn clean package && cd ..
chmod -R 777 ./app/target
echo " "
echo "Concluída a construção da aplicação."
echo " "
echo "-------------------------------"
echo "Implantando o container da aplicação..."
echo "-------------------------------"
echo " "
echo "Aguarde..."
echo " "
sleep 5
echo " "
docker build -t getfood/app ./app
docker run -p 8082:8080 --name app --link bd:host-banco getfood/app
docker logs -f app


