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

**Observações pessoais**: O desafio dessa trilha exigiu a Grande Refatoração do Frontend que teve que ser feita (quase) do zero. Eu achei que gostaria mais de mexer com frontend do que em backend mas centralizar uma caixa div no meio da tela se provou uma tarefa absurdamente difícil e frustrante, mas pelo menos agora a caixa está no meio (vertical) da tela e não mais no cantinho. Em contraste com o frontend anterior em TS/JS puro, no qual toda a lógica estava contida em uma só classe, o frontend atual está dividido em módulos e utiliza o modelo de programação orientada a objetos, além de utilizar o conceito de routing.

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

Os endpoints padrão do microserviço é o /cadastro, e os endpoints das requisições são:
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

**Data de entrega**: 03/05/22
