<h1 align="center">
  Análise de crédito
</h1>

## Sobre o projeto

Projeto desenvolvido para realizar a análise de crédito de clientes, com envio de notificações via SMS para informar o status da proposta, indicando se ela está em análise, foi aprovada ou negada. 

O sistema utiliza uma arquitetura baseada em microsserviços, composta por três APIs: Notificação, Proposta Backend e Análise de Crédito.

Possui integração do AWS SNS para envio de notificações e do RabbitMQ para gerenciamento de filas e comunicação assíncrona entre os microsserviços.

## Tecnologias utilizadas

- Linguagem: Java
- Framework: Spring Boot
- Banco de Dados: PostgreSQL
- Contêinerização: Docker
- Gerenciamento de Dependências: Maven
- Utilitários: Lombok
- Serviço de Notificação: AWS SNS
- Mensageria: RabbitMQ

## Autor
Isabel Henrique

https://www.linkedin.com/in/isabel-henrique/