package zgheroproject.linketinder.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Controller
import zgheroproject.linketinder.model.CandidatoCompetencia
import zgheroproject.linketinder.service.CandidatoCompetenciaService

@Controller
@ComponentScan(basePackages = "zgheroproject.linketinder.service")
class CandidatoCompetenciaController {
    @Autowired
    CandidatoCompetenciaService candidatoCompetenciaService

    @Bean
    CandidatoCompetenciaController initCandidatoCompetenciaController(){
        return new CandidatoCompetenciaController()
    }

    CandidatoCompetencia inserirCandidatoCompetencia(CandidatoCompetencia candidatoCompetencia) {
        return candidatoCompetenciaService.inserirCandidatoCompetencia(candidatoCompetencia)
    }

    List<CandidatoCompetencia> buscarCandidatoCompetencia(String buscaCpf, String nomeBuscaCompetencia){
        return candidatoCompetenciaService.buscarCandidatoCompetencia(buscaCpf, nomeBuscaCompetencia)
    }
}
