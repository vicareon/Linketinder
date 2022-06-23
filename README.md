# ZG Hero Project: Linketinder 2.0

Esse é o repositório do projeto **Linketinder** do programa Acelera ZG, sendo que este é um programa intensivo promovido pela empresa ZG Soluções para a capacitação de novos estagiários em potencial.

O projeto está dividido em etapas, sendo que capa etapa contém trilhas semanais com um projeto avançado que simula uma rotina da empresa. Cada trilha introduz um assunto diferente, como uma prática de programação, framework ou contato com uma nova linguagem. Para fins de referência, esse repositório foi iniciado na trilha 1 do kit 3.

Resolvi separar o projeto em dois repositórios diferentes porque a [versão 1.0](https://github.com/vicareon/ZGHeroProject) não tem nenhum framework.

A IDE utilizada no desenvolvimento é a Intellij IDEA da Jetbrains.

## Trilha 1, parte 3: Spring 
**Assunto**: Framework de Spring

**Descrição do desafio**: Refatoração do microserviço de cadastro utilizando Spring, promovendo a comunicação entre o front e o backend do projeto. 

**Observações pessoais**: Depois de um sentimento generalizado de frustração nas duas últimas trilhas da versão 1.0 que implementaram a comunicação front-back sem nenhum framework, posso afirmar com certeza que os objetivos de demonstrar a importãncia de frameworks e o tanto que isso facilita na hora do desenvolvimento foram cumpridos com sucesso. 

O que exigiu uma maior atenção, na verdade, foi a implementação das camadas de Service e Repository como aplicação do princípio de responsabilidade única explorado na trilha de SOLID visando o máximo desacoplamento possível. Desse modo, retirei a implementação das classes DAO nas classes Controller e as transmiti para as classes Repository, com o relacionamento correto entre Controller e Service: Controller chama Service que chama Repository para realizar a persistência de objetos no banco de dados. O que ajudou a entender a diferença entre Controller e Service foi visualizar uma relação de Gerente e Funcionário.

Na parte de Model, todas as classes foram anotadas com @Entity, assim como seus atributos com @Column a fim de tornar a leitura mais intuitiva e deixar claro a relação com o banco de dados. A persistência de objetos foi realizada com o EntityManager.

Eu também passei 2 horas brigando com a exceção de nullpointer no método de persist() do entityManager porque não adicionei a dependência de JPA no Gradle. 

Aqui estão os tutoriais e artigos que me ajudaram:
- [MVC: Where to add logic](https://stackoverflow.com/questions/23595036/mvc-laravel-where-to-add-logic/25298736#25298736), no StackOverflow
- [Spring Boot - Service Components](https://www.tutorialspoint.com/spring_boot/spring_boot_service_components.htm), no Tutorialspoint
- [REST – PUT vs POST](https://restfulapi.net/rest-put-vs-post/), por Lokesh Gupta
- [Spring Boot Project with Controller Layer + Service Layer + Repository/DAO Layer](https://www.sourcecodeexamples.net/2021/08/spring-boot-project-with-controller.html), no Source Code Examples
- [Not allowed to create transaction on shared EntityManager - use Spring transactions or EJB CMT](https://stackoverflow.com/questions/17860696/not-allowed-to-create-transaction-on-shared-entitymanager-use-spring-transacti), no StackOverflow
- [java.lang.IllegalArgumentException: Unknown entity in Spring + Hibernate Application](https://stackoverflow.com/questions/45191105/java-lang-illegalargumentexception-unknown-entity-in-spring-hibernate-applica), no StackOverflow

**Data de entrega**: 30/05/22

## Trilha 2: Angular
**Assunto**: Framework Angular

**Descrição do desafio**: Implementação do frontend do Linketinder com Angular e operações de cadastro de candidato, empresa, competência e vagas mapeados em endpoint e com comunicação com a model para persistência dos dados.

**Observações pessoais**: O desafio dessa trilha exigiu a Grande Refatoração do Frontend que teve que ser feita (quase) do zero. Eu achei que gostaria mais de mexer com frontend do que em backend porém centralizar uma caixa div no meio da tela se provou uma tarefa absurdamente difícil e frustrante - pelo menos agora a caixa está no meio (vertical) da tela e não mais no cantinho. Em contraste com o frontend anterior em TS/JS puro, no qual toda a lógica estava contida em uma só classe, o frontend atual está dividido em módulos e utiliza o modelo de programação orientada a objetos, além de utilizar o conceito de routing.

As rotas implementadas e seus componentes são:
- /candidato, CandidatoComponent
- /empresa, EmpresaComponent
- /candidato/cadastro, CadastroCandidatoComponent
- /empresa/cadastro, CadastroEmpresaComponent
- /candidato/cadastro/competencia, CadastroCompetenciaComponent
- /empresa/cadastro/vaga, CadastroVagaComponent
- /candidato/vagas, ListaVagasComponent
- /empresa/candidatos, ListaCandidatosComponent

No total foram implementadas as telas:
- Tela inicial geral
- Tela inicial de Candidato
- Tela inicial de Empresa
- Cadastro de Candidato
- Cadastro de Competência de Candidato
- Cadastro de Empresa
- Cadastro de Vaga de Empresa
- Lista de Candidatos
- Lista de Vagas

Na página de início há a opção de escolher entre as opções de Candidato e Empresa, que levam aos seus respectivos index: cadastro e lista de vagas para o Candidato, e cadastro e lista de candidatos para a Empresa. Finalizado o cadastro, o usuário tem a opção de adicionar suas competências se for Candidato e de adicionar vagas se for Empresa. 

Também foram implementados as requisições GET e POST, sendo elas:
- POST no cadastro-candidato: comunica com o endpoint de inserção de Candidato e retorna o alerta de "Candidato cadastrado com sucesso"
- GET no cadastro-competencia: comunica com o endpoint de lista de Competências, retornando as competências já cadastradas na tabela competencias do banco de dados em forma de lista de checkbox 
- POST no cadastro-competencia: comunica com o endpoint de inserção de Competência e retorna o alerta de "Competência cadastrada com sucesso" se não existir no BD
- POST no cadastro-competencia: comunica com o endpoint de inserção de Competência de Candidato e retorna o alerta de "Competência de candidato cadastrada com sucesso" se o CPF informado e a Competência existirem nas tabelas de candidatos e competencia no BD
- POST no cadastro-empresa: comunica com o endpoint de inserção de Empresa e retorna o alerta de "Empresa cadastrada com sucesso"

Tive dificuldade no endpoint de Vagas por causa da array de competências utilizada na tabela, então a integração de Vagas ainda está pendente. O endpoint de lista de candidatos foi mapeado e funciona OK, mas a lista de candidatos tem que ser em formato anônimo (apenas o ID e lista de competências), então também está pendente e provavelmente exige uma refatoração a nível de tabela de banco de dados. 

Também tive dificuldade em pegar o input do usuário dos checkboxes e montar em uma array para jogar na requisição POST de cadastro de competência, então apenas o cadastro de competência está funcional.

Indo para o backend, inseri a modelagem da tabela CandidatoCompetencia de acordo com o padrão MVC, com o Controller, interface DAO, Model, Service e Repository.

Mapeei os endpoints de listagem de competências, candidatos e vagas, porém tenho a consciência que não fazem muito sentido dentro do microserviço de *cadastro*, então planejo criar vários microserviçoes de CRUD para não ferir o princípio de responsabilidade única. 

O endpoint padrão do microserviço é o /cadastro, e os endpoints das requisições são:
- /candidato
- /empresa
- /candidato/competencia (inserção de competência relacionada a candidato na tabela candidato_competencia)
- /candidato/cria-competencia (a nomeação ficou confusa, mas é da inserção de competência na tabela competencia)
- /lista/competencia
- /lista/candidatos
- /lista/vagas

Utilizei o Postman para testagem das APIs. Segue uma lista de tutoriais e artigos que utilizei nessa entrega:

- [Angular Routing](https://angular.io/guide/routing-overview), da documentação do Angular
- [Angular Routing Problem: new page showing below old page](https://stackoverflow.com/questions/54572905/angular-routing-problem-new-page-showing-below-old-page), do StackOverflow
- [Angular HTTP: Como realizar requisições em suas aplicações](https://www.devmedia.com.br/angular-http-como-realizar-requisicoes-em-suas-aplicacoes/40642), do DevMedia
- [Encapsulation: Object Oriented Principles in Typescript](https://medium.com/@raymondjohnson121/encapsulation-object-oriented-principles-in-typescript-5f918813f50e), por Raymond Johnson
- [How to implement Serializable?](https://stackoverflow.com/questions/28788992/how-to-implement-serializable), do StackOverflow
- [Creating Queries Using the Java Persistence Query Language](https://docs.oracle.com/javaee/6/tutorial/doc/bnbrg.html), da documentação do Java EE (extremamente útil)
- [Loop through JSON Array](https://stackoverflow.com/questions/64589527/loop-through-json-array-angular-10), do StackOverflow
- [How do I bind to list of checkbox values with AngularJS?](https://stackoverflow.com/questions/14514461/how-do-i-bind-to-list-of-checkbox-values-with-angularjs), do StackOverflow

**Data de entrega**: 03/06/22

## Trilha 3: Spock
**Assunto**: Testes unitários com Spock

**Descrição do desafio**: Implementação de todos os testes unitários possíveis utilizando Spock.

**Data de entrega**: 07/06/22

## Trilha 4: Grails
**Assunto**: Microserviço com Grails

**Descrição do desafio**: Implementação de microserviço para Vagas.

**Observações pessoais**: A grande dificuldade de Grails é a instalação e se acostumar com a configuração de diretório confusa em comparação com Spring/Micronaut. A curva de aprendizado foi muito grande e não tem muito material disponível que deixa tudo mastigadinho, então tive que me esforçar para esmiuçar a documentação e tentar encaixar as pecinhas... mas quando eu encaixei, toda a raiva e frustração foi embora e me maravilhei com o scaffolding e a ausência de configuração extensa do Spring. 

Links que me foram úteis nessa jornada:

- [Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured](https://stackoverflow.com/questions/51221777/failed-to-configure-a-datasource-url-attribute-is-not-specified-and-no-embedd), do StackOverflow
- [DBConsole in Grails](https://stackoverflow.com/questions/42179053/where-is-dbconsole-in-grails-v3-2-5), do StackOverflow
- [Grails Documentation: Your first Application](https://guides.grails.org/creating-your-first-grails-app/guide/index.html)
- [Stop-app not working](https://github.com/grails/grails-core/issues/11398)
- [Criando uma API Restfull com Grails](https://medium.com/@franklin.bourguignon/criando-uma-api-restfull-com-grails-ab49e1e7632), por Franklin Bourguignon
- [Grails keep deleting my tables](https://stackoverflow.com/questions/6548663/grails-keep-deleting-my-tables), do StackOverflow

**Data de entrega**: 18/06/22

## Trilha 5: Micronaut
**Assunto**: Microserviço com Micronaut

**Descrição do desafio**: Implementação de microserviço para Competências.

**Observações pessoais**: As dependências de Micronaut no Gradle são absolutamente INSUPORTÁVEIS e a documentação não ajudou. O initializer do Intellij para Micronaut tem um bug que coloca 2 dependências jdbc juntas que impedem a inicialização e foi uma dor de cabeça ir testando uma a uma, até que eu desisti e criei um novo projeto em outro repositório sem nenhuma dependência para ir colocando apenas as que eram absolutamente necessárias. Também tem um conflito com Javax e Jakarta (que é também colocado como padrão no initializer).

Assim como em Grails, a curva de aprendizado foi grande - inclusive maior ainda por causa da documentação meio desatualizada em algumas partes e pouco conteúdo pelo framework ainda ser muito recente. 

Depois que consegui encaixar as pecinhas, me maravilhei com a falta de cabeçalho de configuração nos endpoints mas não me sinto segura o suficiente para largar Spring e partir apenas para Micronaut. 

- [Creating a REST Application with Micronaut](https://medium.com/danieldiasjava/creating-a-rest-application-with-micronaut-30a001b3c38b), por Daniel Dias
- [Como usar o Micronaut Data JDBC](https://blog.johnowl.com/como-usar-o-micronaut-data-jdbc/), por João Paulo Gomes
- [JpaRepository findAll() returns empty](https://stackoverflow.com/questions/56371084/jparepository-findall-returns-empty-list), do StackOverflow
- [Micronaut 1.0.RC1 with plain Hibernate JPA fails at startup](https://stackoverflow.com/questions/52633597/micronaut-1-0-rc1-with-plain-hibernate-jpa-fails-at-startup), do StackOverflow

**Data de entrega**: 18/06/22

## Refatoração de microserviço de Spring, database com DataGrip e o frontend em Angular
À medida que o programa se encerra (já são quase mais de 6 meses na data que escrevo isso), as exigências e responsabilidades pesam mais. Isso me levou a duvidar das minhas capacidades e entrei numa espiral de não saber se conseguiria cumprir com os prazos... mas se você está lendo isso aqui, quer dizer que eu consegui sim haha escrevo essa parte para minha eu do futuro ler e saber que vai ficar tudo bem. 

Percebi que meu conhecimento de Spring e Angular não estava tão consolidado por causa da corrida para finalizar a entrega, mas as entregas seguintes dependiam justamente desse conhecimento que fiz nas coxas. 

Nesse período de ansiedade e frustração resolvi comprar o livro *The Pragmatic Programmer (O Programador Pragmático)* e ele me tirou desse fundo do poço ao restaurar minha confiança. Os capítulos são divididos em tópicos (que na verdade são dicas) que podem ser lidos em qualquer ordem.

As que mais me chamaram a atenção e me inspiraram para voltar para a cadeira e encarar as consequências das minhas decisões foram:
> - **1. Se importe com o seu ofício:** porque passar sua vida desenvolvendo software se você não se importar em fazê-lo com qualidade?
> - **2. Reflita! Sobre o seu trabalho:** desligue o piloto automático e retome o controle. Constantemente critique e avalie o seu trabalho.
> - **5. Não viva com janelas quebradas:** arrume designs ruins, decisões erradas e código ruim no momento que você vê-los.
> - **18. Não existem decisões finais:** nenhuma decisão é escrita em pedra.

O resultado final de 3 dias de trabalho intenso foi esse:

- Criação de módulo só para Spring, com divisão bem clara entre Candidato/Empresa e endpoints mais autoexplicativos
- Implementação da interface CrudRepository com custom queries ao invés de ficar reinventando a roda 
- Refatoração de todas as tabelas usando DataGrip porque o PgAdmin 4 não oferece uma experiência de usuário intuitiva para meu nível de conhecimento. Também desisti de mexer com arrays de competências para candidatos e vagas, então foram criadas duas tabelas (candidatos_competencias e vagas_competencias) que servem de ponte para as entidades
- Cada componente do frontend tinha um arquivo .css próprio, mas todos eram iguais - coloquei todos com referência para o .css da página inicial e exclui os arquivos desnecessários
- Criação dos diretórios Candidato e Empresa com subdiretórios ao invés de deixar tudo junto
- Ajuste de endpoints nas requisições

... além das entregas das trilhas 4 e 5 de uma vez só. 

## Trilha 6: Swagger
**Assunto**: Framework Swagger

**Descrição do desafio**: Documentação de todas as APIs do Linketinder usando esse framework.

**Observações pessoais**: Eu já tinha testado todos os endpoints com Postman, então a novidade foi a estrutura da documentação mesmo. Utilizei o [Inspector](https://inspector.swagger.io/builder) para realizar as requisições e o SwaggerHub para edição, mas logo vou ter que abandonar essa ferramenta pela limitação de 3 definições e 20 requisições.

A dificuldade nessa trilha foi a implementação da notação de Cors na API de Spring e que eu esqueci de definir o corpo no método de postagem na API de Micronaut - por exemplo, se a requisição era um objeto JSON com a estrutura { "exemplo":"teste" }, o "teste" ficava como null. 

A documentação está em JSON (resolved e unresolved) em Anexos/Swagger. 

**Data de entrega**: 22/06/22
