# blogMongo

API REST exemplo usando Spring Boot + MongoDB.

Requisitos
- Java 21
- MongoDB rodando em mongodb://localhost:27017 (config em [src/main/resources/application.properties](src/main/resources/application.properties))
- Maven (use o wrapper: `./mvnw`)

Como executar
```sh
./mvnw spring-boot:run
# ou em Windows
mvnw.cmd spring-boot:run
```

Rotas HTTP principais

- Usuários
  - `GET /users` — lista todos os usuários
  - `GET /users/{id}` — busca usuário por id
  - `POST /users` — cria usuário (JSON: `name`, `email`)
  - `PUT /users/{id}` — atualiza usuário (JSON: `name`, `email`)
  - `DELETE /users/{id}` — remove usuário
  - `GET /users/{id}/posts` — lista posts do usuário

- Posts
  - `GET /posts/{id}` — busca post por id
  - `GET /posts/titlesearch?text=` — busca por título (query `text`)
  - `GET /posts/fullsearch?text=&minDate=&maxDate=` — busca por texto e intervalo de datas (datas em ISO-8601, URL-encoded)

Exemplos rápidos

```sh
# buscar todos os usuários
curl -s http://localhost:8080/users

# criar usuário
curl -X POST -H "Content-Type: application/json" \
  -d '{"name":"João","email":"joao@example.com"}' \
  http://localhost:8080/users

# buscar posts por título
curl -s "http://localhost:8080/posts/titlesearch?text=teste"
```

Configuração
- Propriedades: [src/main/resources/application.properties](src/main/resources/application.properties)

Observações
- Ao iniciar a aplicação, a classe de instanciação popula dados de exemplo.
- Consulte o código fonte para detalhes de payloads, validações e exceções.

Licença
- Projeto de exemplo (sem licença especificada).

Sobre este projeto
- Desenvolvido como parte do curso "Java COMPLETO Programação Orientada a Objetos + Projetos" do Nelio Alves (Udemy). O curso aborda Java SE, orientação a objetos, Spring Boot, JPA/Hibernate e MongoDB — tópicos utilizados neste projeto. Mais informações: https://www.udemy.com/course/java-curso-completo/

Fonte: https://www.udemy.com/course/java-curso-completo/ (Nelio Alves)
