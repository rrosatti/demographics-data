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
A INQStats API permite que sejam informados os seguintes parametros: 

- api_key: chave de autenticação
- data: o tipo de dado à ser pesquisado (Ex: birth_rate, education_expenditure)
- countries: país ou países selecionados para realizar a pesquisa
- years: o período selecionado para realizar a pesquisa

Como resultado, os seguintes dados são obtidos:

- countryCode: refere-se ao codigo do país (Ex: br)
- countryName: refere-se ao nome do país (Ex: Brazil)
- {data}: refere-se ao tipo de dado passado como parametro (Ex: population)
  - year: ano referente ao dado pesquisado
  - data: valor referente ao ano especificado

### Volume de dados
O volume de dados irá variar de acordo com os parametros passados no momento da pesquisa.

### Formato de disponibilização dos dados
Os dados são disponibilizados em formato JSON.

### Exemplo de consulta
http://&#8203;inqstatsapi.inqubu.com?api_key=ADDYOURKEYHERE&data=population&countries=us,gb

[{"countryCode":"us","countryName":"USA","population":[{"year":"2014","data":"318857056"},{"year":"2013","data":"316128839"},{"year":"2012","data":"313914040"},{"year":"2011","data":"311587816"},{"year":"2010","data":"309326225"}]},{"countryCode":"gb","countryName":"United Kingdom","population":[{"year":"2014","data":"64510376"},{"year":"2013","data":"64097085"},{"year":"2012","data":"63227526"},{"year":"2011","data":"62752472"},{"year":"2010","data":"62271177"}]}]

O gráfico abaixo é um exemplo de como os dados poderão ser exibidos:

![inqstats_chart](https://cloud.githubusercontent.com/assets/16086636/17643135/d468c302-6136-11e6-8090-1130fe451e4f.png)

