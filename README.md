# Teste Técnico da Prothera

## Descrição

Este projeto foi desenvolvido como parte de um teste técnico para a vaga de Desenvolvedor Full-Stack Júnior na Prothera. O objetivo é gerenciar uma lista de funcionários de uma indústria, realizando diversas operações sobre eles, como inserção, remoção, agrupamento e cálculos diversos.

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

## Pacote Principal 

- **Classe Main**: Responsável pelo fluxo principal do programa. A classe `Main` serve como ponto de entrada da aplicação, onde são instanciadas as classes de serviço e chamadas as funcionalidades principais. Isso ajuda a separar a lógica de execução da lógica de negócios, facilitando a manutenção e o entendimento do código.
