# Teste Técnico da Prothera

## Descrição

Este projeto foi desenvolvido como parte de um teste técnico para a vaga de Desenvolvedor Full-Stack Júnior na Prothera. O objetivo é gerenciar uma lista de funcionários de uma indústria, realizando diversas operações sobre eles, como inserção, remoção, agrupamento e cálculos diversos.

**Tabela**:

<img align="center" src="./Tabela.png" width="604px" height="280px"/>

## Requisitos

O projeto deve atender aos seguintes requisitos:

1. **Classe Pessoa**: 
    - Atributos: nome (String) e data de nascimento (LocalDate).

2. **Classe Funcionário**:
    - Herda da classe Pessoa.
    - Atributos: salário (BigDecimal) e função (String).

3. **Classe Principal**:
    - Ações a serem executadas:
        - 3.1. Inserir todos os funcionários, na mesma ordem e informações conforme a tabela fornecida.
        - 3.2. Remover o funcionário “João” da lista.
        - 3.3. Imprimir todos os funcionários com todas suas informações, sendo que:
           - informação de data deve ser exibido no formato dd/mm/aaaa;
           - informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
        - 3.4. Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        - 3.5. Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        - 3.6. Imprimir os funcionários, agrupados por função.
        - 3.8. Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        - 3.9. Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        - 3.10. Imprimir a lista de funcionários por ordem alfabética.
        - 3.11. Imprimir o total dos salários dos funcionários.
        - 3.12. Imprimir quantos salários mínimos ganha cada funcionário (considerando salário mínimo de R$1212.00).

## Estrutura do Projeto

A estrutura do projeto foi organizado da seguinte forma:

<img align="center" src="./Estrutura projeto.png" width="314px" height="514px"/>

## Pacote Main 

- **Classe Main**: Responsável pelo fluxo principal do programa. A classe `Main` serve como ponto de entrada da aplicação, onde são instanciadas as classes de serviço e chamadas as funcionalidades principais. Isso ajuda a separar a lógica de execução da lógica de negócios, facilitando a manutenção e o entendimento do código.

## Pacote Entities

- **Entidades**: Contém as classes que representam os dados do domínio, como `Pessoa` e `Funcionário`. Separar as entidades em um pacote distinto ajuda a isolar a lógica de negócios das regras de manipulação de dados, tornando o código mais organizado e fácil de entender.

## Pacote Services

- **Serviços**: Contém as classes responsáveis pela lógica de negócios, como `PayrollService` e `EmployeeService`. Colocar a lógica de negócios em serviços separados promove a reutilização de código e facilita a realização de testes unitários, uma vez que a lógica é desacoplada da interface de usuário e das entidades.

## Pacote Factory

- **Fábricas**: Contém classes de fábrica responsáveis por instanciar objetos, como a `EmployeeFactory`. O uso do padrão de design Factory Method permite a criação de objetos de forma centralizada e flexível, promovendo a separação de responsabilidades e facilitando a manutenção do código.

## Testes Unitários

- Os testes unitários são fundamentais para garantir a qualidade e a estabilidade do nosso projeto. Com eles, podemos verificar de forma automatizada cada componente isoladamente, assegurando que cada método se comporte conforme o esperado. Isso não apenas ajuda a identificar bugs precocemente, mas também facilita a manutenção do código ao longo do tempo, promovendo um desenvolvimento mais seguro e eficiente. Com os testes unitários em vigor, podemos ter confiança de que nosso código está funcionando corretamente, mesmo após modificações e expansões. Em resumo, testes unitários são uma prática recomendada para garantir a robustez e escalabilidade dos nossos projetos. Devido a sua importância eu resolvi por testes em meu projeto e testar as principais funcionalidades.

- Para realizar os testes na IDE (Eclipse) basta você realizar os seguintes passos: 
  - Clicar com o botão direito encima do Projeto
  - Clicar em Run As
  - No menu, clique em JUnit Test.
- Após estes passos os testes serão executados.

## Uso

- Clone o repositório: 

```
https://github.com/carloseduardo22-rjce/TesteProthera.git
```

- Depois de clonar, importe-o na sua IDE de preferência e rode o projeto.

## Observação

- Alguns atributos e métodos estão mal indentados e eu desconheço o motivo, pois na minha IDE está normal e quando subo o projeto ocorre isso, enfim, quando você fizer o pull notará que está tudo correto. Eu acredito que seja o próprio GitHub que esteja ocasionando isso. 
