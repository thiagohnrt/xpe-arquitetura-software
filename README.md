# API Publica de E-commerce

API REST para exposicao de dados de Clientes, Produtos e Pedidos para parceiros externos.

O projeto foi implementado com Arquitetura Hexagonal (Ports and Adapters), com separacao clara entre dominio, casos de uso e tecnologias de infraestrutura.

## Sumario

- [Visao geral](#visao-geral)
- [Tecnologias](#tecnologias)
- [Padroes e arquitetura](#padroes-e-arquitetura)
- [Documentacao C4](#documentacao-c4)
- [Estrutura do projeto](#estrutura-do-projeto)
- [Como executar](#como-executar)
- [Swagger e endpoints](#swagger-e-endpoints)
- [Dados iniciais](#dados-iniciais)
- [Tratamento de erros](#tratamento-de-erros)
- [Testes](#testes)
- [Troubleshooting](#troubleshooting)
- [Contribuicao](#contribuicao)
- [Licenca](#licenca)
- [Roadmap](#roadmap)

## Visao geral

A API disponibiliza CRUD completo para os recursos:

- Clientes
- Produtos
- Pedidos

Cada recurso expoe os endpoints obrigatorios:

- `GET /{recurso}`
- `GET /{recurso}/{id}`
- `GET /{recurso}/nome/{nome}`
- `GET /{recurso}/count`
- `POST /{recurso}`
- `PUT /{recurso}/{id}`
- `DELETE /{recurso}/{id}`

## Tecnologias

- Java 25
- Spring Boot 4.0.4
- Spring Web
- Spring Data JPA
- Jakarta Validation
- H2 Database (em memoria)
- SpringDoc OpenAPI + Swagger UI (2.8.8)
- Maven Wrapper (`mvnw` / `mvnw.cmd`)

## Padroes e arquitetura

Principais padroes utilizados:

- Arquitetura Hexagonal (Ports and Adapters)
- Repository Pattern
- Adapter Pattern
- Use Case + Application Service
- Mappers para conversao DTO <-> Domain e Domain <-> Entity
- Global Exception Handler para respostas de erro padronizadas

Fluxo de alto nivel:

1. Requisicao chega no Controller (adapter de entrada).
2. Controller delega para Use Case/Application Service.
3. Service usa portas de repositorio do dominio.
4. Adapter de saida implementa as portas com Spring Data JPA.
5. Resultado retorna em DTO para resposta HTTP.

## Documentacao C4

A documentacao arquitetural no padrao C4 esta em:

- [docs/c4/context.md](docs/c4/context.md)
- [docs/c4/containers.md](docs/c4/containers.md)
- [docs/c4/components.md](docs/c4/components.md)
- [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md)

## Estrutura do projeto

```text
src/main/java/com/empresa/api
|-- domain
|   |-- model
|   |-- repository
|   `-- exception
|-- application
|   |-- dto
|   |-- mapper
|   |-- service
|   `-- usecase
|-- adapters
|   |-- input
|   |   `-- exception
|   `-- output
`-- infrastructure
    `-- persistence
        |-- entity
        |-- jpa
        `-- mapper
```

## Como executar

### Pre-requisitos

- Java 25 instalado
- Maven Wrapper do projeto (recomendado)

### Executar (Windows)

```powershell
.\mvnw.cmd clean spring-boot:run
```

### Executar (Linux/macOS)

```bash
./mvnw clean spring-boot:run
```

### Build

```bash
./mvnw clean package
```

No Windows:

```powershell
.\mvnw.cmd clean package
```

## Swagger e endpoints

Com a aplicacao em execucao, acesse:

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`
- H2 Console: `http://localhost:8080/h2-console`

Recursos da API (base `http://localhost:8080`):

- Clientes: `/clientes`
- Produtos: `/produtos`
- Pedidos: `/pedidos`

## Dados iniciais

O projeto inicializa dados automaticamente via [src/main/resources/data.sql](src/main/resources/data.sql), com registros de exemplo para:

- 3 clientes
- 4 produtos
- 4 pedidos

Isso facilita testes manuais logo apos subir a aplicacao.

## Tratamento de erros

As excecoes sao tratadas de forma centralizada em [src/main/java/com/empresa/api/adapters/input/exception/GlobalExceptionHandler.java](src/main/java/com/empresa/api/adapters/input/exception/GlobalExceptionHandler.java).

Codigos principais retornados:

- 400: erro de validacao ou regra de negocio
- 404: recurso nao encontrado
- 500: erro interno nao tratado

## Testes

Executar todos os testes:

```bash
./mvnw test
```

No Windows:

```powershell
.\mvnw.cmd test
```

## Troubleshooting

- Java incorreto: o projeto exige Java 25 (`java -version`).
- Porta ocupada: altere `server.port` em `application.properties`.
- Swagger nao abre: confira se a aplicacao subiu sem erros e use exatamente `/swagger-ui/index.html`.
- Dados nao aparecem: valide `spring.sql.init.mode=always` e `spring.jpa.defer-datasource-initialization=true` em [src/main/resources/application.properties](src/main/resources/application.properties).

## Roadmap

Melhorias que podem elevar o projeto:

- Adicionar seguranca (autenticacao/autorizacao).
- Evoluir cobertura de testes de unidade e integracao.
- Adicionar versionamento de API (exemplo: `/api/v1`).
