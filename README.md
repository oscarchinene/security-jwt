# 🔐 Projeto Security - Autenticação com Spring Boot e JWT

Este projeto é um **backend Java** utilizando **Spring Boot 3**, **Spring Security** e **JWT** para autenticação e proteção de endpoints.  
Permite registrar, autenticar usuários e testar rotas protegidas com token JWT.

---

## 🧩 Tecnologias

- Java 21
- Spring Boot 3
- Spring Security
- JWT (Auth0)
- PostgreSQL
- Flyway
- Maven
- Lombok

---

## ⚙️ Configuração e Execução

### 1️⃣ Clonar o repositório
```bash
git clone https://github.com/oscarchinene/security-jwt.git
```
### 2️⃣ Configurar o banco de dados
```
spring.datasource.url=jdbc:postgresql://localhost:5432/security
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.flyway.enabled=true
```
### 3️⃣ Rodar a aplicação
```
mvn spring-boot:run
```
- A aplicação estará disponível em:
```
http://localhost:8080
```
### 🔑 Endpoints
| Método | Endpoint         | Descrição                   | Autenticação |
|--------|-----------------|-----------------------------|--------------|
| POST   | /auth/register   | Registra um novo usuário     | Não          |
| POST   | /auth/login      | Faz login e retorna JWT      | Não          |
| GET    | /test            | Testa rota protegida         | Sim          |

## 🧪 DTOs (Requests e Responses)

### 1️⃣ RegisterUserRequest
**Request** (`POST /auth/register`):
```json
{
  "name": "Paulo Jose",
  "email": "paulojose@example.com",
  "password": "12345"
}
```
- Response (RegisterUserResponse 201 Created):
```
{
  "nome": "Paulo Jose",
  "email": "paulojose@example.com"
}
```
### 2️⃣ LoginRequest

**Request** (`POST /auth/login`):
```
{
  "email": "paulojose@example.com",
  "password": "12345"
}
```
- Response (`LoginResponse 200 OK`):
```
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```
- 💡 Dica: Use o token retornado no login no cabeçalho Authorization para acessar endpoints protegidos:
```
Authorization: Bearer <SEU_TOKEN>
```
### 🧾 Entidades principais
#### User

- Campos:

  - id (Long, PK)

  - name (String, não nulo)

  - email (String, único e não nulo)

  - password (String, não nulo)

- Implementa UserDetails do Spring Security para autenticação.

#### JWTUserData

- Campos:

  - userId (Long)

  - email (String)

- Usado para armazenar dados do usuário dentro do token JWT.

### 🔐 JWT

- Geração: TokenConfig.generateToken(User user)

- Validação: TokenConfig.validateToken(String token)

- Expiração: 24 horas

- Cabeçalho HTTP:
```
Authorization: Bearer <SEU_TOKEN>
```




