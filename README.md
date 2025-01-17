
## Dependencias
Java 21
Docker


Docker commands
```shell
docker network create local-network
docker-compose -f docker-compose.yml up
```

Swagger
http://localhost:8090/swagger-ui/index.html

Depois com alguma aplicação de chamada de API

Validações:

* Caso 2 - Salva no PostgreSQL
```shell
curl --location 'http://localhost:8090/cep/04757000'
```

PGadmin
http://localhost:8080/browser/
(dados de acesso na configuração do docker-compose.yml)


* Caso 2 - Salva no Mongodb Cloud
```shell
curl --location 'http://localhost:8090/cep2/04757000'
```

Acesso no mongodb cloud - user external
user: external
pass: zgKhEmg4P9aZjBPx

Evidencias dos tests:
![Screenshot from 2024-07-12 00-45-51.png](..%2F..%2FPictures%2FScreenshots%2FScreenshot%20from%202024-07-12%2000-45-51.png)
