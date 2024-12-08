* [Título](#Título) <h1 align="center">Aplicação - EcoVoz (Back-End)</h1>

* [Status do Projeto](#Status-do-Projeto)

<p align="center">
<img src="https://img.shields.io/badge/Status-Concluído-green">
</p>
<br>

* [Como executar em Linux](#Como-executar-em-Linux)

Essa aplicação, tanto o back-end quanto o front-end, foi testada em Windows.

Para executar propriamente a aplicação, é necessário inicializar o back-end e, em seguida, inicializar o front-end com o comando "npm run dev" no prompt da sua IDE de preferência.
* [Principais ferramentas utilizadas](#Ferramentas-utilizadas)

 `Java versão 18: linguagem utilizada como a base do back-end.`

 `SpringBoot: framework escolhido, em associação com as dependências do Java versão 18, para desenvolvimento e organização do back-end.`

  `Postman: Programa escolhido para consumir e testar os endpoints desenvolvidos no back-end.`

  `PostgressSQL: Banco de dados escolhido para desenvolvimento e manipulação do banco de dados. Em associação com este, foi empregado o DBeaver como o sistema de gerenciamento do banco
  criado.`
 
* [Introdução](#Introducao)

O presente projeto foi realizado tendo como objetivo o desenvolvimento de uma aplicação que permita a criação, administração e gerenciamento de denúncias de crimes ambientais flagrados no cotidiano para auxiliar as autoridades ambientais, militares e governamentais no combate aos mesmos. A idealização adveio do fato da fiscalização ambiental no Brasil ser insuficiente por vários motivos, dentre eles a falta de contigente especializado nessa tarefa e também pelo fato de ser uma nação de proporções continentais, dificultando assim o combate a essa categoria criminal.

* [Descrição do projeto](#Descriçao-do-projeto)

<p>O back-end da aplicação EcoVoz foi desenvolvido empregando o conceito de camadas para fins de organização do projeto. A camada de persistência tem classes com sufixo "Repository" que conectarão o endpoint com o banco de dados. A camada de negócios é mantida principalmente por classes com sufixo "Service" que abrigam as regras e validações dos endpoints e por classes com sufixo "Entity" que são os objetos que mapeiam as tabelas do banco. Ainda sobre esta camada, ela é sustentada por classes de suporte como DTOs e enums. Por fim, a camada de visualização é composta por controladores que definem as rotas dos endpoints que empregam verbos HTTP como GET, POST, PUT e PATCH.

Das rotas:

>A rota '/api/v1/weather-forecast' foi desenvolvida como sendo a principal fonte de dados dinâmicos entre back-end e front-end. Ela possui um método Get para retornar a previsão climática especificamente da cidade de Florianópolis e possui um método Post que retornará a previsão climática das cidades escolhidas no front-end.

> A rota '/api/v1/usersFeedback' foi desenvolvida como se uma fonte de dados estática, ou mock, referente ao feedback que usuários da uClimate já compartilharam para ser consumida na landing page do front-end.

</p>

* [Desenvolvedor](#Desenvolvedor)
<h4>Eike Hirsch ✒️ LinkedIn: https://www.linkedin.com/in/eike-hirsch/</h4>
