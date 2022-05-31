package zgheroproject.linketinder.controller

import zgheroproject.linketinder.model.Candidato
import zgheroproject.linketinder.service.CandidatoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
class CandidatoController{
    @Autowired
    CandidatoService candidatoService

    Candidato inserirCandidato(Candidato candidato) {
        return candidatoService.inserirCandidato(candidato)
    }
}