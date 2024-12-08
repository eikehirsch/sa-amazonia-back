* [Título](#Título) <h1 align="center">Aplicação - uClimate (Back-End)</h1>

* [Status do Projeto](#Status-do-Projeto)

<p align="center">
<img src="https://img.shields.io/badge/Status-Concluído-green">
</p>
<br>

* [Como executar em Linux](#Como-executar-em-Linux)

Essa aplicação, tanto o back-end quanto o front-end, foi testada em Linux utilizando o programa Oracle VM Virtual Box para criar uma máquina virtual Linux. Nessa máquina virtual criada, foi instalado o Ubuntu e, com ele, a aplicação foi executada utilizando o VSCode do Ubuntu.

Para executar propriamente a aplicação, é necessário iniciar o back-end com o comando "npm start" e, em seguida, iniciar o front-end também com o comando "npm start". Essa executação funciona igualmente no Windows com os mesmos comandos.

* [Principais ferramentas utilizadas](#Ferramentas-utilizadas)

 `Node.js: tecnologia utilizada como a base do back-end.`

 `Express: framework escolhido, em associação com as dependências Nodemon e Cors, para criação e organização do back-end.`

  `API OpenWeather: principal API da aplicação. É consumida no back-end para retornar previsões climáticas de acordo com as cidades que foram escolhidas no front-end. Essa API está vinculado à outra API que é consumida no front-end chamada Geoapify. A utilização da Geoapify foi necessária para descobrir a longitude e latitude das cidades escolhidas no front.`
 
* [Introdução](#Introducao)

O presente projeto foi realizado tendo como objetivo o desenvolvimento de uma aplicação que permita ao usuário consultar previsões climáticas especificamente da cidade de Florianópolis e também de qualquer cidade brasileira, em diferentes páginas, retornando ao usuário informações interessantes como temperatura média dos próximos dias, velocidade média do vento, umidade relativa do ar etc.

* [Descrição do projeto](#Descriçao-do-projeto)

<p>O back-end da aplicação uClimate foi desenvolvido empregando o conceito MVC (Model-Viewer-Controller) para fins de organização do projeto. Por conta disso, cada rota do back-end utilizará seu respectivo controlador para executar os métodos GET ou POST quando requisitados.

Das rotas:

>A rota '/api/v1/weather-forecast' foi desenvolvida como sendo a principal fonte de dados dinâmicos entre back-end e front-end. Ela possui um método Get para retornar a previsão climática especificamente da cidade de Florianópolis e possui um método Post que retornará a previsão climática das cidades escolhidas no front-end.

> A rota '/api/v1/usersFeedback' foi desenvolvida como se uma fonte de dados estática, ou mock, referente ao feedback que usuários da uClimate já compartilharam para ser consumida na landing page do front-end.

</p>

* [Desenvolvedor](#Desenvolvedor)
<h4>Eike Hirsch ✒️ LinkedIn: https://www.linkedin.com/in/eike-hirsch/</h4>
