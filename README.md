<h1 align="center">Desafio - Consulta de vendas</h1>

- **Relatório de vendas**

    1. [IN] O usuário informa, opcionalmente, data inicial, data final e um trecho do nome do vendedor.

    2. [OUT] O sistema informa uma listagem paginada contendo id, data, quantia vendida e nome do
       vendedor, das vendas que se enquadrem nos dados informados.

       **Informações complementares**

        -  Se a data final não for informada, considerar a data atual do sistema. Para instanciar a data atual,

       utilize o comando:

        - Se a data inicial não for informada, considerar a data de 1 ano antes da data final. P

        - Se o nome não for informado, considerar o texto vazio.

        - Dica: receba todos os dados como String no controller, e faça os tratamentos



- **Sumário de vendas por vendedor**

    1. [IN] O usuário informa, opcionalmente, data inicial, data final.

    2. [OUT] O sistema informa uma listagem contendo nome do vendedor e soma de vendas deste vendedor
       no período informado.

  **Informações complementares:**

    -  As mesmas do caso de uso Relatório de vendas

<h2>Como executar as consultas localmente</h2>

Criar e executar o projeto em seu ambiente de desenvolvimento local é muito fácil. Certifique-se de ter o Git e JDK17 instalados e siga as instruções abaixo.
(Estas instruções pressupõem que você esteja instalando como um usuário root.)

1. Clone o código fonte

   ````https://github.com/GilbertoSEspinoso/desafio-consulta-vendas.git````

2. Em sua IDE de preferência(utilizei Intellij), importe a pasta **desafio-consulta-vendas** e faça o update das dependências do maven.

3. Ao executar o projeto, o mesmo pode ser acessado no teu próprio navegador, use esse endereço: http://localhost:8080/h2-console

4. Collections do postman para fazer as requisições GET - Link : https://www.getpostman.com/collections/a5929fa46ba2b6a991d4



<h2>Tecnologias utlizadas</h2>

- Java
- Springboot
- JPA / JPQL
- Maven
- H2 Database






