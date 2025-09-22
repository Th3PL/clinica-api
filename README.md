# 🏥 Clinica-API
[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/seuusuario/EchoID/actions)
[![OpenAPI](https://img.shields.io/badge/OpenAPI-Swagger-blue)](http://localhost:8080/swagger-ui.html)
[![License: MIT](https://img.shields.io/badge/license-MIT-green)](LICENSE)

API REST desenvolvida para gerenciar uma clínica médica, permitindo o cadastro de pacientes e médicos, além do agendamento, confirmação e cancelamento de consultas.

## 👤 Endpoints Paciente 
| Recurso                | Endpoint          | Método | 
|------------------------|-------------------|--------|
| Criar paciente         | `/pacientes`      | POST   | 
| Listar pacientes       | `/paciente`       | GET    |
| Buscar paciente por ID | `/pacientes/{id}` | GET    |
| Atualizar paciente     | `/pacientes/{id}` | PUT    |
| Deletar paciente       | `/pacientes/{id}` | DELETE |

## 👨‍⚕️ Endpoints Médico
| Recurso              | Endpoint            | Método | 
|----------------------|---------------------|--------|
| Criar medico         | `/medico`           | POST   | 
| Listar medicos       | `/medico`           | GET    |
| Buscar medico por ID | `/medico/{id}`      | GET    |
| Atualizar medico     | `/medico/{id}`      | PUT    |
| Deletar medico       | `/medico/{id}`      | DELETE |
| Cria Consulta        | `/consulta`         | POST   |

## 🏨 Endpoints clínica
| Recurso                     | Endpoint                           | Método | Descrição                                                      |
|-----------------------------|------------------------------------|--------|----------------------------------------------------------------|
| Criar Consulta              | `/consultas/novaConsulta`          | POST   | Cria uma nova consulta                                         |
| Confirmar Consulta          | `/consultas/confirmarConsulta{id}` | PUT    | Muda status de uma consulta para CONFIRMADA com base no ID     |
| Cancelar Consulta           | `/consulta/cancelarConsulta{id}`   | PUT    | Muda status de uma consulta para CANCELADA com base no ID      |
| Listar Consultas por médico | `/consulta/medico/{id}`            | GET    | Lista todas as consultas de um médico específico com base no ID|

## 🛠️ Alterações Realizadas
- Padronização de respostas da API
- Refactor E-mail e CPF de entidade para atributo
- Coreção DTO´s
  -  Estavam em 1 aquivo só oque comprometia a execução do projeto, além de não corresponder aos padrões de arquitetura
- Inclusão de novos DTO's
- Correçao camada repository
  - Exclusão de métodos não utilizaos e inclusäo de novos

# 🎓 
| Nome                                 | RM       |
|--------------------------------------|---------- |
| 🚀 Pedro Lucas de Andrade Nunes      |RM550366 |
