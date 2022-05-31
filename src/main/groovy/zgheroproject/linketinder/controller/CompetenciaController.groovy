package zgheroproject.linketinder.controller

import zgheroproject.linketinder.model.Competencia
import zgheroproject.linketinder.service.CompetenciaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
class CompetenciaController{
    @Autowired
    CompetenciaService competenciaService

    Competencia inserirCompetencia(Competencia competencia) {
        return competenciaService.inserirCompetencia(competencia)
    }
}