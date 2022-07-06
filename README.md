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

## Trilha 1, parte 4: Kafka
**Assunto**: Kafka e Mensageria

**Descrição do desafio**: Criação de microserviço de envio de emails utilizando Kafka e o conceito de mensageria, no qual a cada inserção de vaga no banco de dados, um email de alerta é enviado para todos os candidatos cadastrados na plataforma com o nome da vaga e uma mensagem customizada.

**Observações pessoais**: No dia que estou escrevendo essa descrição (dia 06/07) já se passou tempo o suficiente para eu esquecer do que eu queria colocar aqui. Lembro que não foi uma experiência agradável entregar essa trilha em apenas 1 dia (mesmo com um estudo prévio anterior), porque na hora de sentar na cadeira e codar é que o filho chora e a mãe não vê. 

A ideia é a seguinte: temos o microserviço de email (EmailMicroservice) construído com Spring e que tem o consumidor do Kafka. O produtor ficou no microserviço de vagas construído com Grails, e a comunicação entre os dois acontece antes da validação da vaga no banco de dados quando faz uma requisição POST para o endpoint. 

Grails age de maneiras misteriosas e scaffolding é um exemplo disso. Não pude alterar diretamente o método de persistência, então a alternativa que encontrei foi mexer no domain de Vagas e inserir um evento beforeValidate().

Infelizmente não pude completar o requisito de pegar a lista de email de candidatos e enviar os emails mas consigo enviar o email para um endereço de teste, então ainda está valendo.

Felizmente eu salvei o material que me guiou para colocar aqui:

- [Spring Boot - Apache Kafka](https://www.tutorialspoint.com/spring_boot/spring_boot_apache_kafka.htm), no TutorialsPoint
- [Spring Boot + Apache Kafka Hello World Example](https://www.javainuse.com/spring/spring-boot-apache-kafka-hello-world), no JavaInUse
- [Emailing microservice made easy](https://www.sipios.com/blog-tech/emailing-microservice-apache-kafka-spring-boot), por Kévin Guilloy
- [Spring Boot - Sending Email via SMTP](https://www.geeksforgeeks.org/spring-boot-sending-email-via-smtp/), no GeeksforGeeks

**Data de entrega**: 27/06/22

## Trilha 2: Docker
**Assunto**: -

**Descrição do desafio**: -

**Observações pessoais**: A dificuldade com Docker já começou na sua instalação, porque o Docker Desktop tinha o docker-ce-cli como dependência obrigatória para instalação e o guia de instalação oficial não funcionava de jeito nenhum, dizendo que o repositório não existia. 

Partindo para o estudo prévio (ou seja, antes de começar a escrever código), peguei o conceito de diferença entre imagem e container muito rápido graças à explicação extremamente simples do professor ao comparar a imagem à Classe e o container ao Objeto - tudo fez sentido e fiquei animada para aplicar esse novo conhecimento o mais rápido possível, pensando que a única dificuldade que eu teria com esse projeto já tinha passado.

Paguei pela minha ingenuidade logo depois com o container de Postgresql e o PgAdmin4. 

De início tentei criar um novo servidor utilizando os dois e até consegui, mas não conseguia conectá-lo de jeito nenhum com os outros microserviços. Com a ajuda do tutor, nos aventuramos no mundo de pgclusters e outros termos que nunca vi. Tentamos de tudo e nada. A dificuldade foi tanta que precisamos de ajuda de um desenvolvedor extremamente experiente que resolveu o problema que se arrastava a 2 dias em 30 minutos. Não sei se ele vai chegar a ler isso aqui, mas obrigada de novo... [ainda tenho muito a aprender](https://pbs.twimg.com/media/EaKX9nMXgAIt9RU?format=jpg&name=360x360).

Outros desafios estavam à espera: o Dockerfile de cada módulo de microserviço com todas as particularidades de seus frameworks. Isso aqui foi praticamente um rito de passagem porque em todas as trilhas anteriores eu conseguia achar algum guia, ou tutorial, ou thread no StackOverflow que descrevia exatamente (ou chegava muito próximo) o que eu estava passando.

Agora eu estava sozinha, porque achar um Dockerfile que vai dar exatamente certo com a configuração da sua aplicação logo de cara se mostrou uma tarefa quase impossível. Com exceção apenas do microserviço de Spring, na qual a documentação resolveu exatamente o meu problema, tive que ir pegando pedacinhos de cada exemplo que eu encontrava, testar, ver que não deu certo e procurar outro exemplo que talvez teria o pedacinho que estava faltando. Os dockerfiles são pequenininhos, com apenas algumas linhas, mas o esforço foi enorme para alguém que estava tendo contato com Docker pela primeira vez. 

É uma carga enorme para enfiar na cabeça de uma vez só, especialmente porque tem uma deadline te espreitando a cada momento e a ansiedade começa a aparecer quando as coisas não estão (ainda) dando certo... mas a satisfação de ver tudo rodando bonitinho em cada container fez tudo valer a pena. Talvez deve ser a mesma sensação de correr uma maratona, mas eu não sei como é essa sensação porque nunca corri uma maratona.

Materiais que me guiaram:

- [How to Run PostgreSQL and pgAdmin Using Docker](https://towardsdatascience.com/how-to-run-postgresql-and-pgadmin-using-docker-3a6a8ae918b5), por Mahbub Zaman
    - [Mesmo tutorial mas em português](https://renatogroffe.medium.com/postgresql-pgadmin-4-docker-compose-montando-rapidamente-um-ambiente-para-uso-55a2ab230b89), por Renato Groffe
    - [Outro tutorial que também ajudou](https://www.programandocomcarlos.com.br/2020/01/postgresql-pgadmin-4-docker-compose.html), por Carlos Dorneles
- [Installing Docker in Ubuntu, from repo: can't find repo](https://stackoverflow.com/questions/71393595/installing-docker-in-ubuntu-from-repo-cant-find-a-repo), no StackOverflow - única alternativa que funcionou para mim, resolve o problema de instalação do docker-ce-cli com o repositório mais recente 
- [How to create a Dockerfile for a Micronaut App](https://johnnystarr.io/2021/04/17/how-to-create-a-dockerfile-for-a-micronaut-app/), por Johnny Starr - exemplo de Dockerfile para Micronaut
- [Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker/), na documentação de Spring - exemplo de Dockerfile que funciona de primeira, serviu para entender os comandos de build e run junto com Gradle
- [Deploying a Spring Based War in a Docker Container](https://www.javainuse.com/devOps/docker/docker-war), no JavaInUse - exemplo de Dockerfile para Grails
- [Spring Boot + Kafka + Zookeeper](https://codefresh.io/docs/docs/yaml-examples/examples/spring-boot-kafka-zookeeper/), na documentação do Codefresh 
    - [Repositório](https://github.com/codefreshdemo/example-springboot-kafka) no GitHub com o exemplo de docker-compose juntando as duas imagens

As imagens estão disponíveis no Dockerhub (requer login):
- [Email](https://hub.docker.com/repository/docker/vicareon/emailmicroservice)
- [Micronaut](https://hub.docker.com/repository/docker/vicareon/micronautmicroservice)
- [Grails](https://hub.docker.com/repository/docker/vicareon/grailsmicroservice)
- [Spring](https://hub.docker.com/repository/docker/vicareon/springmicroservice) 

**Data de entrega**: 05/07/22

## Tutorial: Como realizar deploy dos containers do Linketinder
Uma sugestão do desafio da trilha de Docker foi a elaboração de um tutorial explicando como realizar o deploy dos containers para que as pessoas que não tem muito domínio. Antes de executar o tutorial no Intellij, é necessário rodar os containers do Postgres e do pgAdmin 4. O arquivo docker-compose está disponível na pasta de anexos clicando aqui.

Agora, dentro do Intellij (ou da sua IDE de preferência) -

1. Abrir um terminal local para cada módulo da aplicação
2. Construir o jar/war com o Gradle:
> ./gradlew build
3. Executar o dockerfile para construção de um container a partir da imagem:
> docker build -t [nome do microserviço] .
4. Rodar o container na porta desejada:
> docker run -p [porta do localhost]:[porta do container] [nome do microserviço]

A fins de referência, as portas mapeadas na aplicação são:
> Grails: 8080
>
> Spring: 8081
>
> Micronaut: 8082
>
> Email: 8083

## Trilha 3: Jenkins
**Assunto**: -

**Descrição do desafio**: -

**Observações pessoais**: - 

**Data de entrega**: pendente
