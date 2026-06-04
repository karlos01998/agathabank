🏦 AgathaBank — Sistema Bancário em Terminal

O AgathaBank é uma aplicação de simulação bancária desenvolvida inteiramente em Java Core. O projeto funciona como um laboratório prático de Engenharia de Software, onde regras de negócios complexas e rigorosas validações de segurança são processadas diretamente no terminal, entregando uma interface de usuário (UX) limpa, simétrica e padronizada.
🚀 Funcionalidades do Sistema (O que o código faz)

O sistema simula com precisão as operações reais de duas modalidades de contas independentes: Conta Corrente e Conta Poupança.

    Abertura de Contas Dinâmica:

        Cadastro estruturado validando a integridade física do CPF (exigência estrita de 11 dígitos numéricos).

        Validação automática de faixa etária impeditiva (permissão restrita para usuários entre 18 e 100 anos).

        Criação de credenciais com imposição de senhas numéricas fortes de exatamente 6 dígitos.

        Proteção de integridade que impede a duplicidade de cadastros para um mesmo CPF.

    Autenticação Segura (Login):

        Fluxo de acesso isolado por modalidade de conta (Corrente ou Poupança).

        Sistema de segurança integrado com travas antifraude: bloqueio imediato do aplicativo após 3 tentativas consecutivas de erro de CPF ou de senha (proteção contra ataques de força bruta).

    Movimentações Financeiras e Pix:

        Pix por Chave CPF: Transferências instantâneas entre contas do mesmo tipo ou cruzadas (Corrente para Poupança e vice-versa).

        Validação de Liquidez: Checagem em tempo real do saldo antes da autorização de qualquer débito, impedindo saldos negativos.

        Tela de Confirmação: Exibição prévia dos dados nominais do destinatário antes do fechamento da transação para evitar envios errados.

    Consulta e Comprovantes:

        Saldo: Consulta rápida e limpa dos valores disponíveis.

        Extrato Consolidado: Histórico detalhado de transações realizadas (Quem enviou, quem recebeu e o valor).

        Comprovante de Transação: Emissão automática de um layout detalhado após o sucesso de cada Pix.

🏛️ Arquitetura Técnica e Engenharia do Software

Para suportar essas funcionalidades de forma estável e escalável, o código foi blindado utilizando os padrões arquiteturais mais exigidos pelo mercado:

    Arquitetura em Camadas (Layered Architecture): Desacoplamento total do sistema sob a regra de isolamento Controller ➡️ Service ➡️ Repository.

        Controller: Maestro do fluxo, gerencia estritamente o ciclo de vida das telas e a captura de entradas.

        Service: Onde reside o "coração" do banco; responsável exclusivo pelas regras de negócio e validações matemáticas.

        Repository: Isolamento completo do armazenamento e persistência de dados em memória através de coleções estruturadas.

    Padrão MVC (Model-View-Controller): Separação absoluta entre os dados estruturais do sistema e a interface visual de console exposta ao usuário (Camada View).

    Programação Orientada a Objetos (POO) Avançada: Uso rigoroso de encapsulamento (private), herança legítima a partir de uma classe mãe (ModelBank) e polimorfismo aplicado em construtores e sobrescritas de métodos (@Override).

    Data Transfer Objects (DTO): Transporte de pacotes de dados imutáveis e extremamente seguros entre as camadas do software através do uso de Java records.

    Proteção de Memória e JVM: Otimização da memória Heap utilizando constantes de classe (public static final), uso correto de tipos primitivos de alta capacidade (long) para evitar estouros numéricos e eliminação completa de recursões indiretas para mitigar riscos de StackOverflowError.

    Distribuição Independente: Empacotamento profissional do software via jpackage, gerando uma imagem de execução autônoma contendo uma runtime cortada do Java 21, permitindo que a aplicação rode em qualquer ambiente Windows de forma portátil (sem dependência de JRE instalada na máquina do cliente).