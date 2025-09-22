# Lab02S02 - CRUD de Cliente (Java Web MVC + Swagger)

Este módulo implementa o CRUD de **Cliente** conforme os requisitos do sistema de aluguel de automóveis.

## Stack
- Spring Boot 3 (Web, Validation)
- Spring Data JPA + H2 (memória)
- MVC (Controller → Service → Repository → Entity)
- Swagger UI (springdoc-openapi) em `/swagger-ui.html`

## Rodando
```bash
mvn spring-boot:run
# ou
./mvnw spring-boot:run
```
Aplicação: `http://localhost:8080`  
Swagger UI: `http://localhost:8080/swagger-ui.html`  
H2 Console: `http://localhost:8080/h2-console` (JDBC: `jdbc:h2:mem:lab02s02`, user `sa`, password `password`)

## Endpoints
- `POST /api/clientes` – cria cliente
- `GET /api/clientes` – lista clientes
- `GET /api/clientes/{id}` – busca por id
- `PUT /api/clientes/{id}` – atualiza cliente
- `DELETE /api/clientes/{id}` – remove cliente

### Regras/Validações
- `cpf` com 11 dígitos e único.
- Até **3** empregos/rendimentos por cliente.
- Emprego: `entidadeEmpregadora` obrigatório, `rendimentoMensal` ≥ 0.

## Próximos passos (Lab02S03)
- Autenticação/autorização (cadastro prévio).
- CRUDs adicionais (Agentes, Pedidos, Automóveis).
- Fluxo para criação e avaliação de pedido de aluguel.
```
