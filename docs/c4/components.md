# C4 - Componentes (API Spring Boot)

## Componentes

- Controllers REST (adapters input)
- Services/UseCases (application)
- Portas de repositorio (domain)
- Adapters de repositorio (adapters output)
- Spring Data JPA repositories (infrastructure)
- Entities + Mappers de persistencia (infrastructure)

## Interacoes

1. Controller recebe request e valida payload.
2. Service executa regra e consulta porta de repositorio.
3. Adapter de repositorio converte dominio <-> entidade e usa Spring Data.
4. Service devolve resposta para o controller.
5. GlobalExceptionHandler padroniza erros HTTP.
