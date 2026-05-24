# 📈 Evolução Planejada e Linha do Tempo Técnica

O AgathaBank é um laboratório vivo. A lista abaixo reflete os marcos tecnológicos já consolidados no código e os próximos passos da minha jornada de aprendizado em Engenharia de Software.

### 🟢 Etapas Concluídas (Consolidadas no Projeto)
- [x] **Lógica de Programação Avançada**
  * Controle de fluxo limpo utilizando estruturas iterativas (`do-while` e `switch-case`).
  * Eliminação de anti-padrões de fluxo, como recursão indireta (evitando *StackOverflowError*).
- [x] **Programação Orientada a Objetos (POO) Aplicada**
  * Uso estrito de Encapsulamento (`private`, `protected`) e métodos acessores (Getters/Setters) com validações.
  * Abstração e Reutilização de código através de Herança legítima baseada em uma classe mãe (`ModelBank`).
  * Polimorfismo de construtores acoplados via `super()` e sobrescritas de métodos (`@Override`).
- [x] **Arquitetura Baseada em Camadas (Three-Tier Architecture)**
  * Desacoplamento do projeto seguindo o padrão de mercado: **Controller ➡️ Service ➡️ Repository**.
  * **Controller:** Responsável estritamente pelo ciclo de vida das telas, menus e capturas de dados.
  * **Service:** Concentração exclusiva das regras de negócio e validações lógicas.
  * **Repository:** Isolamento total da manipulação de dados e coleções em memória (`ArrayList`).
- [x] **Padrão de Arquitetura MVC (Model-View-Controller)**
  * Separação completa entre a lógica do sistema e a interface de console do usuário (Camada `View`).
- [x] **Data Transfer Objects (DTO)**
  * Transporte seguro e imutável de pacotes de dados entre camadas utilizando Java `records` (`DTOCurrent` e `DTOSavings`).
- [x] **Mecanismos de Segurança e Proteção de Memória**
  * Criação de algoritmo antifraude com contadores de tentativas isolados para CPF e Senha, bloqueando acessos suspeitos por força bruta.
  * Otimização de uso da memória Heap da JVM através de constantes de classe (`public static final`).
  * Blindagem contra estouros de capacidade numérica usando tipos primitivos adequados (`long`).
- [x] **Versionamento de Código Profissional**
  * Gestão de histórico, resolução de conflitos upstream (*Merge/Pull*) e sincronização via Git/GitHub integrados à IDE.

---

### 🟡 Próximos Passos (A Evolução do Laboratório)
- [ ] Persistência com Banco de Dados Relacional
- [ ] Conectividade com Java Database Connectivity (JDBC)
- [ ] Migração para o ecossistema Spring Boot
