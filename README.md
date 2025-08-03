
# mensageria-payflux

![Kafka](https://img.shields.io/badge/Apache%20Kafka-000?logo=apachekafka&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=white)
![Apache Avro](https://img.shields.io/badge/Apache%20Avro-1F2D3D?logo=apache&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2%20Database-0072C6?logo=h2&logoColor=white)

---

## 📖 Sobre o projeto
O **mensageria-payflux** é um sistema desenvolvido para processar boletos por meio de mensageria.  
Ele realiza:
- Recepção do boleto
- Validação
- Processamento do pagamento
- Notificação do status

Toda a comunicação entre os sistemas é feita utilizando **Apache Kafka**.

---

## 🏗 Arquitetura

Fluxo do projeto:

![Arquitetura](https://github.com/user-attachments/assets/0dff7ced-6b21-4a1b-aecd-01815d6e7be7)

1. A API recebe a solicitação do boleto e grava no banco.
2. As informações são enviadas para os tópicos do Kafka:
    - **Tópico de pagamento**
    - **Tópico de notificação**
3. Serviços consumidores processam:
    - **Validação**
    - **Pagamento**
    - **Notificação**
4. Dados finais são salvos no banco.

---

## 🛠 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Apache Kafka**
- **Apache Avro**
- **Schema Registry**
- **Control Center**
- **Docker**
- **Banco de dados H2**

---

## 🚀 Como executar o projeto

### Pré-requisitos
- Docker e Docker Compose instalados
- Java 17+

### Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/mensageria-payflux.git

# Acesse a pasta do projeto
cd mensageria-payflux

# Suba os containers do Kafka e do Schema Registry
docker-compose up -d

# Rode a aplicação Spring Boot
./mvnw spring-boot:run
```

---

## 📂 Estrutura do projeto

```
mensageria-payflux/
│
├── api/                  # Recepção de boletos
├── consumers/            # Serviços consumidores (validação, pagamento, notificação)
├── docker-compose.yml    # Configuração do ambiente Docker

```

---

## 🔗 Endpoints principais
- `POST /boletos` – Recebe um boleto para processamento

---

## ✨ Autor
**João Marcos**  
Projeto do curso de mensageria

---

