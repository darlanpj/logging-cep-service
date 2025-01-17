
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

![Screenshot from 2025-01-16 21-52-09](https://github.com/user-attachments/assets/9700c7d4-92e0-400c-83b0-6815b283b523)
![Screenshot from 2025-01-16 22-36-51](https://github.com/user-attachments/assets/bb98af7e-6169-4d83-81d6-1fe4b7e3bfa0)


