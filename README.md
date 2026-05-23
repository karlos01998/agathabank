# 🏦 AgathaBank

O **AgathaBank** é um simulador de ecossistema bancário baseado em console, desenvolvido em Java puro. O objetivo principal deste projeto é aplicar de forma prática os pilares da Programação Orientada a Objetos (POO), padrões de arquitetura de software e boas práticas de desenvolvimento de backend em uma aplicação monolítica estável e segura.

---

## 🎯 Escopo do Projeto

O projeto consiste em um sistema de terminal que simula as operações essenciais de um banco real, dividindo as contas em duas categorias com regras de negócio específicas: **Conta Corrente** e **Conta Poupança**.

### 💼 Funcionalidades Principais
* **Abertura de Contas:** Cadastro de novos clientes coletando dados obrigatórios (CPF, Nome e Data de Nascimento).
* **Autenticação Segura:** Sistema de Login estruturado que valida de forma casada o CPF e a senha do usuário antes de liberar o menu de operações.
* **Menu de Operações Avançadas:** Após o login, o usuário ganha acesso a recursos de movimentação financeira (Saques, Depósitos e Consultas de Saldo).

### 🛠️ Regras de Negócio e Segurança Implementadas
* **Mecanismo Antifraude (Bloqueio de Acesso):** Implementação de contadores de tentativas isolados para CPF e Senha no escopo da classe controladora. O sistema barra o usuário e encerra a aplicação (`System.exit(0)`) após 3 falhas consecutivas, mitigando ataques de força bruta.
* **Validação de Saldo Segura:** O saldo das contas é blindado contra valores negativos através de validações com interrupção explícita (`return;`) nos métodos modificadores (`setBalance`).
* **Taxa de Rendimento Eficiente:** As contas poupança possuem uma taxa de rendimento nativa e imutável de `0.5%` (`TAXA_RENDIMENTO`), definida estaticamente em nível de classe para otimização de memória Heap.
* **Segurança de Tipos Numéricos:** Tratamento de dados sensíveis (como CPF) utilizando primitivos `long` com sufixos explícitos, evitando estouro de capacidade e bugs de leitura de base octal.

---

## 📐 Arquitetura do Sistema

O projeto adota o padrão arquitetural **MVC (Model-View-Controller)** para garantir o desacoplamento completo de responsabilidades:

* **Model (Camada de Dados):** Contém as entidades de negócio (`ModelBank`, `ModelCurrentBank`, `ModelSavingsBank`). É responsável pela estrutura dos dados, validações internas e encapsulamento dos atributos.
* **View (Camada de Interface):** Classes focadas estritamente na interação com o usuário via console (captura de dados pelo teclado com `Scanner` e exibição de menus). Não possui regras de lógica ou processamento.
* **Controller (Camada de Controle):** O cérebro do aplicativo. Gerencia o fluxo de navegação entre as telas utilizando estruturas limpas de `switch-case` e loops `do-while` iterativos, evitando o uso de recursão indireta e protegendo a pilha de execução da JVM contra falhas de `StackOverflowError`.

---

## 🚀 Tecnologias e Conceitos de POO Utilizados

* **Linguagem:** Java 17 / 21
* **Abstração & Encapsulamento:** Uso estrito de modificadores de acesso (`private`, `protected`, `public`) e métodos getters/setters estruturados para proteção de dados.
* **Herança & Polimorfismo:** Reutilização de código através de uma classe mãe (`ModelBank`) repassando comportamentos e atributos comuns para as classes filhas via construtores acoplados com `super()`.
* **Data Transfer Objects (DTO):** Utilização de Java `records` (`DTOCurrent` e `DTOSavings`) para o transporte limpo, imutável e seguro de pacotes de dados entre a View e o Controller.

---

## 🚧 Status do Projeto

O projeto encontra-se em **fase ativa de construção** e evolução. Novas funcionalidades de persistência de dados e refinamentos nas regras de transações financeiras estão sendo adicionadas progressivamente.
