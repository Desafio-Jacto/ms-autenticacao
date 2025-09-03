# 🚀 Microsserviço de Cadastro e Autenticação

[![Docker](https://img.shields.io/badge/Docker-Ready-blue?logo=docker)](https://www.docker.com/)
[![Swagger](https://img.shields.io/badge/Swagger-Docs-orange?logo=swagger)](http://localhost:8080/swagger-ui.html)

Este projeto utiliza **Docker** e possui documentação via **Swagger** para facilitar o desenvolvimento e testes da API.

---

## 🛠️ Pré-requisitos

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- Banco de dados (PostgreSQL configurado)

---

## 🚀 Rodando o projeto

1. **Subir os containers do projeto**


docker-compose up -d
Isso irá iniciar todos os serviços necessários.

---

## 🗄️ Banco de Dados

O projeto inclui um arquivo SQL para criar e popular a base de dados:

- **Arquivo:** `script.sql` (na raiz do projeto)  
- Execute este arquivo na sua base de dados PostgreSQL.

---

## 📄 Acessando o Swagger

Após iniciar os containers, acesse a documentação da API:
- http://localhost:8080/swagger-ui.html
