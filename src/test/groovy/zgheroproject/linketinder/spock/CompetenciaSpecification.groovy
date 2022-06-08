package zgheroproject.linketinder.spock

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import spock.lang.Specification
import zgheroproject.linketinder.controller.CompetenciaController
import zgheroproject.linketinder.model.Competencia

@SpringBootTest
@ComponentScan(basePackages = "zgheroproject.linketinder.*")
class CompetenciaSpecification extends Specification{
    @Autowired
    CompetenciaController competenciaController

    void "Teste de cadastro"(){
        given: "Criação de competência com parâmetro de teste e inicialização de bean competenciaController"
        def competencia = new Competencia("Teste")
        competenciaController.initCompetenciaController()

        when: "Chamada de método de controller de inserção de competência"
        competenciaController.inserirCompetencia(competencia)

        then: "Verifica se a competência foi adicionado ao banco de dados"
        competenciaController.buscarCompetencia("Teste")
    }
}
