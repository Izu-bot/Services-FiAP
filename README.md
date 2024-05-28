# Microsserviços em Spring Boot
Este é um projeto de exemplo que demonstra a implementação de uma arquitetura de microsserviços usando Spring Boot para criar APIs RESTful e MySQL como banco de dados.

## Visão Geral
O projeto consiste em vários microsserviços, cada um responsável por uma parte específica da funcionalidade da aplicação. Eles se comunicam uns com os outros através de chamadas de API RESTful.

### Microsserviços

* Serviço auth: Serviço para cadastro de usuários, login, autenticação e autorização;
* Serviço Coleta de lixo: Serviço que gerencia a coleta de lixo na vizinhança;
* Serviço Rastreio de caminhões: Serviço que gerencia os caminhões de lixo;
* Serviço Notificação: Notifica os moradoes de quando é necessario separa os lixos reciclveis para coleta;
