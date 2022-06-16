package zgheroproject.linketinder.spock

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import spock.lang.Specification

@SpringBootTest
@ComponentScan(basePackages = "zgheroproject.linketinder.*")
class CandidatoCompetenciaSpecification extends Specification{
    @Autowired
    CandidatoCompetenciaController candidatoCompetenciaController

    void "Teste de cadastro"(){
        given: "Criação de competência com parâmetro de teste e inicialização de bean competenciaController"
        def candidatoCompetencia = new CandidatoCompetencia("teste cpf", "teste")
        candidatoCompetenciaController.initCandidatoCompetenciaController()

        when: "Chamada de método de controller de inserção de competência"
        candidatoCompetenciaController.inserirCandidatoCompetencia(candidatoCompetencia)

        then: "Verifica se a competência foi adicionado ao banco de dados"
        candidatoCompetenciaController.buscarCandidatoCompetencia("teste cpf", "teste")
    }
}
