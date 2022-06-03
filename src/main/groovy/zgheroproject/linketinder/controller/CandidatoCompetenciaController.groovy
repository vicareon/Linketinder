package zgheroproject.linketinder.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import zgheroproject.linketinder.model.CandidatoCompetencia
import zgheroproject.linketinder.service.CandidatoCompetenciaService

@Controller
class CandidatoCompetenciaController {
    @Autowired
    CandidatoCompetenciaService candidatoCompetenciaService

    CandidatoCompetencia inserirCandidatoCompetencia(CandidatoCompetencia candidatoCompetencia) {
        return candidatoCompetenciaService.inserirCandidatoCompetencia(candidatoCompetencia)
    }
}
