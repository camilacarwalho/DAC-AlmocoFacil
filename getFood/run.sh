docker build -t getfood/bd ./postgres
docker run -p 5433:5432 --name getfood-bd -d getfood/bd
docker logs -f getfood-bd

