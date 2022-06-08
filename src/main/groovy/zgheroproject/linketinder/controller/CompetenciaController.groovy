package zgheroproject.linketinder.controller

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import zgheroproject.linketinder.model.Competencia
import zgheroproject.linketinder.service.CompetenciaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
@ComponentScan(basePackages = "zgheroproject.linketinder.service")
class CompetenciaController{
    @Autowired
    CompetenciaService competenciaService

    @Bean
    CompetenciaController initCompetenciaController(){
        return new CompetenciaController()
    }

    Competencia inserirCompetencia(Competencia competencia) {
        return competenciaService.inserirCompetencia(competencia)
    }

    List<Competencia> buscarCompetencia(String nomeBuscaCompetencia){
        return competenciaService.buscarCompetencia(nomeBuscaCompetencia)
    }
}