FROM openjdk:11
COPY src/ /src/
RUN javac /src/main/groovy/zgheroproject/linketinder/CompetenciasApplication.groovy
ENTRYPOINT ["java","-jar","micronautmicroservice-0.1.jar","zgheroproject.linketinder.CompetenciasApplication"]