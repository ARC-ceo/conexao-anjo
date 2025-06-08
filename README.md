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
├── Projeto Java/            # Projeto Quarkus (API)
│   └── src/
│   └── pom.xml
│
└── Front-End/           # Projeto Front-end 
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
   git clone https://github.com/ARC-ceo/conexao-anjo.git
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

1. Abra essa pasta dentro do VS-CODE
   ```bash
   cd ../Front-End
   ```
   
2. Execute o live server apartir do arquivo index.html:
  
3. Redirecionado para o navegador


---

## 🧪 Testes

Para rodar os testes do backend:

```bash
./mvnw test
```

---

## 📫 Contato

Grupo ARC - Projeto Conexão Anjo  
Youtuve - Grupo ARC

---

