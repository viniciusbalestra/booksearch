# BookSearch

Um projeto Spring Boot para buscar e gerenciar informações sobre livros e autores, utilizando a API Gutendex para enriquecer os dados.

## 📚 Visão Geral

O BookSearch é uma aplicação back-end desenvolvida em Spring Boot que permite aos usuários interagir com um catálogo de livros e autores. Ele consome dados da API Gutendex, armazena-os em um banco de dados PostgreSQL e oferece funcionalidades de busca e listagem através de uma interface de console ou futura API REST.

## ✨ Funcionalidades

O projeto oferece as seguintes funcionalidades principais:

1.  **Buscar Livros**: Permite buscar livros utilizando critérios específicos, consumindo dados da API Gutendex.
2.  **Listar Livros Registrados**: Exibe todos os livros que foram salvos no banco de dados local.
3.  **Listar Autores Registrados**: Exibe todos os autores que foram salvos no banco de dados local.
4.  **Listar Autores Vivos em Determinado Ano**: Permite encontrar autores que estavam vivos em um ano específico.
5.  **Listar Livros por Idioma**: Filtra e exibe livros com base no idioma especificado.

## 🚀 Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias e frameworks:

* **Java 17**: Linguagem de programação.
* **Spring Boot 3.5.3**: Framework para desenvolvimento rápido de aplicações Java.
* **PostgreSQL**: Banco de dados relacional para armazenamento dos dados.
* **Maven**: Ferramenta de automação de build e gerenciamento de dependências.
* **Jackson Databind**: Biblioteca para serialização/desserialização de JSON.
* **API Gutendex**: API pública utilizada para buscar dados de livros e autores.

## 🛠️ Configuração e Execução

Para configurar e executar o projeto em sua máquina local, siga os passos abaixo:

### Pré-requisitos

* Java Development Kit (JDK) 17 ou superior.
* Maven.
* Um servidor PostgreSQL em execução.

### Passos

1.  **Clone o Repositório:**
    ```bash
    git clone [URL_DO_SEU_REPOSITORIO]
    cd booksearch
    ```

2.  **Configurar o Banco de Dados PostgreSQL:**
    * Crie um banco de dados PostgreSQL para o projeto (ex: `booksearch_db`).
    * Atualize as configurações do banco de dados no arquivo `src/main/resources/application.properties` (ou `application.yml`):

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/booksearch_db
    spring.datasource.username=seu_usuario_postgresql
    spring.datasource.password=sua_senha_postgresql
    spring.jpa.hibernate.ddl-auto=update # ou create, se preferir que o JPA crie as tabelas
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    ```
    *Substitua `seu_usuario_postgresql` e `sua_senha_postgresql` pelas suas credenciais.*

3.  **Compilar o Projeto:**
    Utilize o Maven para compilar o projeto e baixar as dependências:
    ```bash
    mvn clean install
    ```

4.  **Executar a Aplicação:**
    Você pode executar a aplicação Spring Boot de duas maneiras:

    * **Via Maven:**
        ```bash
        mvn spring-boot:run
        ```
    * **Via JAR Executável:**
        ```bash
        java -jar target/booksearch-0.0.1-SNAPSHOT.jar
        ```

### Uso

Após iniciar a aplicação, ela provavelmente apresentará um menu de opções no console, permitindo que você interaja com as funcionalidades listadas acima (buscar livros, listar autores, etc.).

## 🤝 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues para reportar bugs, sugerir melhorias ou enviar pull requests.
