# Task Management API
Este projeto é uma API para gerenciamento de tarefas construída com Java 22. Ele utiliza o banco de dados em memória H2 e inclui documentação da API utilizando Swagger.

## Requisitos

- Java 22
- IntelliJ IDEA (ou outra IDE de sua escolha)
- Maven 3.6+

## Configuração do Projeto
### Passo 1: Clonar o Repositório

- Clone este repositório para sua máquina local


### Passo 2: Executar o maven

- mvn spring-boot:run


### Passo 3: Configuração o h2
- Abra o application.properties e configure a gosto, aqui vão alguns itens que podem ser levados em consideração:

# Dados de conexão com o banco H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# Configuração do cliente web do banco H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configuração para mostrar o SQL no console
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


### Passo 4: Configuração do arquivo import.sql

- Mantenha a sintaxe do sql: INSERT INTO task (finished, creation_date, limit_date, description) VALUES (false, '2024-05-28 09:00:00.000000', '2024-06-05 12:00:00.000000', 'example 123');


