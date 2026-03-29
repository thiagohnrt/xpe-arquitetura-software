# C4 - Containers

## Containers principais

- API Spring Boot: expoe endpoints REST e aplica casos de uso.
- Banco H2: persiste dados de clientes, produtos e pedidos.
- Swagger UI: documenta e permite testar os endpoints.

## Relacoes

1. Parceiros -> API Spring Boot via HTTP/JSON.
2. API Spring Boot -> H2 via JPA/Hibernate.
3. Parceiros e equipe -> Swagger UI para exploracao da API.
