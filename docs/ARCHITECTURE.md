# Arquitetura da API

A API segue o estilo Hexagonal (Ports and Adapters), separando o nucleo de dominio das tecnologias externas.

## Camadas

- Domain: modelos de negocio e portas de repositorio.
- Application: casos de uso, servicos e DTOs.
- Adapters Input: controllers REST e tratamento de excecoes.
- Adapters Output: implementacoes das portas de repositorio.
- Infrastructure: entidades JPA, repositorios Spring Data e mapeamentos de persistencia.

## Fluxo

1. Requisicao HTTP chega no controller (adapter de entrada).
2. Controller chama um use case da camada Application.
3. Use case usa portas do dominio para persistencia.
4. Adapter de saida implementa a porta usando Spring Data JPA.
5. Resultado retorna em DTO para o controller, que responde HTTP.

## Estrutura de Pastas

- src/main/java/com/empresa/api/domain
- src/main/java/com/empresa/api/application
- src/main/java/com/empresa/api/adapters/input
- src/main/java/com/empresa/api/adapters/output
- src/main/java/com/empresa/api/infrastructure/persistence

## Decisoes

- Pedido simplificado com: id, clienteId, dataPedido, valorTotal.
- H2 em memoria com criacao automatica de tabelas via JPA.
- Busca por nome para Pedido interpreta nome como clienteId textual.
