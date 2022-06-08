package zgheroproject.linketinder.spock

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import spock.lang.Specification
import zgheroproject.linketinder.controller.CandidatoController
import zgheroproject.linketinder.model.Candidato

@SpringBootTest
@ComponentScan(basePackages = "zgheroproject.linketinder.*")
class CandidatoSpecification extends Specification{
    @Autowired
    CandidatoController candidatoController

    void "Teste de cadastro"() {
        given: "Criação de candidato com parâmetros de teste e inicialização de bean candidatoController"
        def candidato = new Candidato("teste nome", "teste email", "teste cep", "teste estado", "teste país", "teste descrição", "senha", "teste cpf", "teste formação acadêmica", "teste idade")
        candidatoController.initCandidatoController()

        when: "Chamada de método de controller de inserção de candidato"
        candidatoController.inserirCandidato(candidato)

        then: "Verifica se o candidato foi adicionado ao banco de dados"
        candidatoController.buscarCandidato("teste cpf")
    }
}