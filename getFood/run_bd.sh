echo "Implantando o banco de dados..."
docker build -t getfood/bd ./postgres
docker run -p 5433:5432 --name bd -d getfood/bd
docker logs bd


#echo "Implantando a aplicação..."
#mvn clean install
#cd shared && mvn clean package && cd ..
#chmod -R 777 ./shared/target
#cd app && mvn clean package && cd ..
#chmod -R 777 ./app/target

#docker build -t getfood/app ./app
#docker run -p 8082:8080 --name app --link bd:host-banco getfood/app
#docker logs -f app


