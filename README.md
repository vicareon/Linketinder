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
