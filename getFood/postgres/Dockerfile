FROM postgres
ENV POSTGRES_DB getFood
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD 123
COPY create.sql /docker-entrypoint-initdb.d/
COPY insert.sql /docker-entrypoint-initdb.d/
