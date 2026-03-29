# C4 - Contexto

## Sistema

API Publica de E-commerce.

## Atores

- Parceiros Externos: consomem endpoints REST de clientes, produtos e pedidos.
- Equipe Interna: monitora e evolui a API.

## Sistemas Externos

- Banco H2 (em memoria) para armazenamento dos dados.

## Visao

Parceiros externos acessam a API para consultar e manter dados de negocio. A API centraliza validacao, regras de aplicacao e persistencia.
