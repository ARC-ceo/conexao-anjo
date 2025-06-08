# 🤝 Conexão Anjo - API Quarkus

Projeto desenvolvido pelo **Grupo ARC** com o propósito de conectar **pessoas que precisam de ajuda** com **pessoas que querem doar**.

Este repositório contém a **API backend**, construída com [Quarkus](https://quarkus.io/), que alimenta a plataforma **Conexão Anjo**. Também indicamos onde acessar o projeto **front-end**.

---

## 📌 Objetivo

Facilitar conexões solidárias entre doadores e pessoas em situação de vulnerabilidade, por meio de uma plataforma ágil, segura e de fácil uso.

---

## 📁 Estrutura do Projeto

```
conexao-anjo/
│
├── backend/            # Projeto Quarkus (API)
│   └── src/
│   └── pom.xml
│
└── frontend/           # Projeto Front-end (React, Angular, etc.)
    └── index.html
```

---

## 🚀 Como Executar o Projeto

### 🔧 Pré-requisitos

- Java 17+
- Maven 3.8+
- Git
- Node.js e npm (para executar o front-end)

---

### 🖥️ Backend (Quarkus API)

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/conexao-anjo.git
   cd conexao-anjo/backend
   ```

2. Compile o projeto:
   ```bash
   ./mvnw clean install
   ```

3. Inicie o servidor em modo dev:
   ```bash
   ./mvnw quarkus:dev
   ```

4. Acesse a API:
   ```
   http://localhost:8080
   ```

---

### 💻 Frontend

1. Em outra aba do terminal, navegue até a pasta do front:
   ```bash
   cd ../frontend
   ```

2. Instale as dependências:
   ```bash
   npm install
   ```

3. Execute o projeto:
   ```bash
   npm start
   ```

4. Acesse no navegador:
   ```
   http://localhost:3000
   ```

---

## 🧪 Testes

Para rodar os testes do backend:

```bash
./mvnw test
```

---

## 📫 Contato

Grupo ARC - Projeto Conexão Anjo  
Email: contato@grupoarc.org  
Instagram: [@grupoarc](https://instagram.com/grupoarc)

---

## 📝 Licença

Este projeto está licenciado sob a **MIT License**. Veja o arquivo `LICENSE` para mais detalhes.
