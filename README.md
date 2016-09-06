# Demosoft

### Repositório
https://github.com/rrosatti/demographics-data

### Membros da Equipe
- Rodrigo Rosatti Galvão / RA: 176939 / Email: rodrigo_rosatti@hotmail.com / Github: https://github.com/rrosatti
- Luis Fernando Panicachi Cocovilo Filho / RA: 173166 / Email: crynando@outlook.com / Github: https://github.com/CryNando
- Rogério Takashi Hirata / RA: 176976 / Email: rogeriotakashi@hotmail.com / Github: https://github.com/rogeriotakashi
- Tiago Alves da Silva / RA: 177697 / Email: tiagorts1996@hotmail.com / Github: https://github.com/tiagorts

### Motivação
O Projeto Demosoft tem como objetivo exibir informações relevantes relacionadas a diversos dados demográficos. Esses dados podem ser utilizados em diversas ocasiões, desde uma pesquisa escolar ou até mesmo para conhecimento próprio. Portanto, o Demosoft permitirá que uma série de dados relevantes sejam reunidos em um mesmo lugar e que os mesmos sejam disponíveis de forma prática e interativa para os usuários.

### Fonte de dados
Utilizaremos uma API gratuita chamada INQStats - http://blog.inqubu.com/inqstats-open-api-published-to-get-demographic-data

### Descrição dos dados
O usuário poderá consultar os seguintes tópicos:

Birth Rate / Taxa de Natalidade </br>
Corruption Index / Índice de corrupção </br>
Death Rate / Taxa de Mortalidade </br>
Education Expenditure / Gastos com Educação </br>
Forest Area Percent / Porcentagem de Area Florestal </br>
Happiness Index / Índice de Felicidade </br>
HDI (Human Development Index) / IDH (Índice de Desenvolvimento Humano) </br>
Health Expenditure / Gastos com Saúde </br>
Internetusers Percent / Porcentagem de Usuários com Acesso a Internet </br>
Life Expectancy / Expectativa de Vida </br>
Literacy Rate / Taxa de Alfabetismo </br>
Population / População </br>
Research Expenditure / Gastos com Pesquisas

Além disso, o usuário poderá escolher entre os seguintes países para realizar tal consulta:

Brazil, Chile, USA, Canada, Portugal, Norway(Noruega), South Africa(África do Sul), Angola, China, Japan(Japão), Australia and New Zealand(Nova Zelândia)

### Volume de dados
O volume de dados irá variar de acordo com os parametros passados no momento da consulta. Mas, o volume total de dados é de aproximadamente 100KB.

### Formato de disponibilização dos dados
Os dados são disponibilizados em formato JSON.

### Exemplo de consulta
Países: USA, Brazil
Tópico: Population / População

[{"countryCode":"us","countryName":"USA","population":[{"year":"2014","data":"318857056"},{"year":"2013","data":"316128839"},{"year":"2012","data":"313914040"},{"year":"2011","data":"311587816"},{"year":"2010","data":"309326225"}]}]
[{"countryCode":"br","countryName":"Brazil","population":[{"year":"2014","data":"206077898"},{"year":"2013","data":"204259377"},{"year":"2012","data":"202401584"},{"year":"2011","data":"200517584"},{"year":"2010","data":"198614208"}]}]

O gráfico abaixo é um exemplo de como os dados poderão ser exibidos:

![inqstats_chart_2](https://cloud.githubusercontent.com/assets/16086636/17671680/aa672d14-62ee-11e6-9156-741f700d077d.png)

### Protótipos
Tela com gráfico gerado
![tela com grafico gerado](https://cloud.githubusercontent.com/assets/7906573/18284837/ff8de99a-7441-11e6-85a2-5763acd09058.png)

Tela com menu aberto
![tela com menu aberto](https://cloud.githubusercontent.com/assets/7906573/18284851/10d60d40-7442-11e6-8909-208002cdf507.png)

Tela com comparação entre os países
![tela com comparacao entre paises](https://cloud.githubusercontent.com/assets/7906573/18284859/1636b870-7442-11e6-8457-be9b33162827.png)


