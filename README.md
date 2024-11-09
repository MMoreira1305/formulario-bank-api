API de cadastro de LEAD´s com dados vindo do formulário
Esta é uma API RESTful desenvolvida com Java 17, Spring Boot 3.3, Swagger para documentação interativa, MySQL como banco de dados e Flyway para migrações de banco de dados. A API também integra-se com uma solução de mensageria desenvolvida utilizando Apache Kafka.

Sumário
- Tecnologias Utilizadas
Pré-Requisitos
Configuração do Ambiente
Executando a API Localmente
Migrations Flyway
Swagger
Endpoints
Integração com Kafka
Contribuições
Licença
Tecnologias Utilizadas
Java 17 (JDK)
Spring Boot 3.3 (Framework backend)
Swagger 3 (Documentação e testes interativos da API)
MySQL (Banco de dados relacional)
Flyway (Gerenciamento de migrações de banco de dados)
Kafka (Mensageria)
Maven (Gerenciador de dependências)

Pré-Requisitos
Antes de rodar a aplicação, certifique-se de ter as seguintes ferramentas instaladas:

JDK 17 ou superior: Download JDK
MySQL 8.x: Download MySQL
Apache Kafka: Download Kafka
Maven: Download Maven
Configuração do Ambiente
1. Banco de Dados
Crie um banco de dados no MySQL chamado example_db ou altere a configuração do banco de dados no arquivo application.properties.

Exemplo de configuração no application.properties:

properties
Copiar código
spring.datasource.url=jdbc:mysql://localhost:3306/example_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

Migrations Flyway
Este projeto usa o Flyway para gerenciar as migrações do banco de dados. As migrações estão localizadas na pasta src/main/resources/db/migration. Cada arquivo de migração é numerado sequencialmente (ex: V1__Create_table.sql).

Exemplo de um arquivo de migração:
sql
Copiar código
-- V1__Create_table.sql
CREATE TABLE example_table (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);
Quando a aplicação for executada, o Flyway irá automaticamente aplicar as migrações para o banco de dados configurado.

Swagger
A documentação da API está disponível através do Swagger. Após rodar a aplicação, você pode acessar a documentação interativa em:

bash
Copiar código
http://localhost:8080/swagger-ui.html
Endpoints
Exemplo de Endpoints Disponíveis
1. POST /api/messages
Envia uma mensagem para o sistema de mensageria via Kafka.

Request body:

json
Copiar código
{
  "userId": 123,
  "message": "Olá, sistema!"
}
Resposta:

200 OK: Mensagem enviada com sucesso.
2. GET /api/messages/{messageId}
Recupera uma mensagem específica.

Parâmetro de caminho:

messageId: ID da mensagem a ser recuperada.
Resposta:

200 OK: Retorna a mensagem.
404 Not Found: Mensagem não encontrada.
Integração com Kafka
Esta API é integrada com o Kafka para envio e recebimento de mensagens. As mensagens enviadas são enviadas para um tópico específico do Kafka.

Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests. Para contribuir:

Fork o repositório.
Crie uma nova branch (git checkout -b minha-nova-feature).
Faça as alterações desejadas e adicione testes se necessário.
Faça o commit das mudanças (git commit -am 'Adiciona nova funcionalidade').
Envie a branch para o repositório remoto (git push origin minha-nova-feature).
Abra um pull request.

Att, Matheus Moreira.
