# Contexto do Projeto

Você é um Arquiteto de Software responsável por projetar e implementar uma API pública para uma empresa de e-commerce.

A empresa precisa disponibilizar dados para parceiros externos através de uma API REST.

Os dados disponibilizados pertencem aos seguintes domínios:

- Clientes
- Produtos
- Pedidos

---

# Objetivo

Projetar, documentar e implementar uma API REST que:

- Utilize Arquitetura Hexagonal (Ports and Adapters)
- Seja desenvolvida em Java com Spring Boot
- Utilize banco de dados em memória H2
- Exponha endpoints REST completos para os domínios
- Seja escalável, desacoplada e testável

---

# Requisitos Funcionais

A API deve suportar os seguintes recursos:

- Cliente
- Produto
- Pedido

Cada recurso deve implementar:

## CRUD

- Criar
- Atualizar
- Deletar
- Consultar

## Endpoints obrigatórios

GET /{recurso}
GET /{recurso}/{id}
GET /{recurso}/nome/{nome}
GET /{recurso}/count
POST /{recurso}
PUT /{recurso}/{id}
DELETE /{recurso}/{id}

---

# Arquitetura

A aplicação deve seguir Arquitetura Hexagonal com separação clara de camadas:

## Camadas

- Domain (núcleo da aplicação)
- Application (casos de uso)
- Infrastructure (integrações externas)
- Adapters (entrada e saída)

## Princípios

- Independência de frameworks
- Baixo acoplamento
- Alta coesão
- Inversão de dependência

---

# Stack Tecnológica

- Java 25+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok (opcional)
- SpringDoc OpenAPI (Swagger)

---

# Modelagem de Domínio

## Cliente

- id
- nome
- email

## Produto

- id
- nome
- preco

## Pedido

- id
- clienteId
- dataPedido
- valorTotal

---

# Estrutura do Projeto

src/main/java/com/empresa/api

domain
    model
    repository

application
    service
    usecase

infrastructure
    persistence
    config

adapters
    input (controllers)
    output (repositories)

---

# Banco de Dados

- Utilizar H2 em memória
- Inicialização automática
- Console habilitado (/h2-console)

---

# Documentação da API

- Swagger/OpenAPI
- Endpoint: /swagger-ui/index.html

---

# Documentação Arquitetural

Criar diagramas no padrão C4:

- Contexto
- Containers
- Componentes

Ferramenta sugerida:

- draw.io

---

# Critérios de Aceite

- API funcional
- CRUD completo para os 3 domínios
- Endpoints adicionais funcionando
- Arquitetura hexagonal aplicada corretamente
- Separação de camadas clara
- Banco H2 funcional
- Swagger disponível
- Diagrama C4 criado
- Código organizado e documentado

---

# Entregáveis

- Código fonte
- Documentação arquitetural (C4)
- Estrutura de pastas explicada
- Repositório Git (opcional)
