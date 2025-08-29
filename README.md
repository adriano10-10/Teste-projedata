# 🏭 Teste Prático de Programação - Java

Este projeto foi desenvolvido para atender ao **teste prático de programação** da indústria, envolvendo manipulação de listas de funcionários e execução de operações como agrupamento, filtragem, ordenação e cálculos salariais.

---

## 📁 Estrutura do Projeto

- **`Pessoa`**  
  Representa uma pessoa com os seguintes atributos:

  - `nome` (String)
  - `dataNascimento` (LocalDate)

- **`Funcionario`** (extends Pessoa)  
  Representa um funcionário com atributos adicionais:

  - `salario` (BigDecimal)
  - `funcao` (String)

- **`Principal`**  
  Classe principal responsável por executar todas as ações do teste:
  - Inserção de funcionários
  - Remoção
  - Impressão formatada
  - Agrupamento por função
  - Ordenação e cálculos salariais

---

## ✅ Requisitos Implementados

1. Inserção de todos os funcionários na lista.
2. Remoção do funcionário `"João"`.
3. Impressão de todos os funcionários com:
   - Data de nascimento no formato `dd/MM/yyyy`.
   - Salário formatado com ponto como separador de milhar e vírgula como decimal.
4. Aplicação de **10% de aumento** nos salários.
5. Agrupamento dos funcionários por função (`Map<String, List<Funcionario>>`).
6. Impressão dos funcionários agrupados por função.
7. Impressão dos funcionários com aniversário nos meses **10** e **12**.
8. Impressão do funcionário com a **maior idade** (nome e idade).
9. Impressão da lista de funcionários por **ordem alfabética**.
10. Cálculo e impressão do **total de salários**.
11. Cálculo e impressão de quantos **salários mínimos** cada funcionário recebe (salário mínimo = R$ 1.212,00).

> ⚠️ Caso algum requisito não tenha sido totalmente implementado, foi comentado no código.

---

## 🛠 Tecnologias e Ferramentas

- Linguagem: **Java 17+**
- IDE recomendada: **IntelliJ IDEA / Eclipse / NetBeans**
- Bibliotecas padrão do Java (sem dependências externas)

---

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone <link-do-repositório>
   ```
