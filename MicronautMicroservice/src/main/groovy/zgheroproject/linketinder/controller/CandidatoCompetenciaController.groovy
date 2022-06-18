package zgheroproject.linketinder.controller

import jakarta.inject.Inject
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import zgheroproject.linketinder.model.CandidatoCompetencia
import zgheroproject.linketinder.service.CandidatoCompetenciaService

@RestController("/competencia/candidato")
class CandidatoCompetenciaController {
    @Inject
    private CandidatoCompetenciaService candidatoCompetenciaService

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    void salvarCandidatoCompetencia(CandidatoCompetencia candidatoCompetencia){
        candidatoCompetenciaService.salvarCandidatoCompetencia(candidatoCompetencia)
    }

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<CandidatoCompetencia> listarTodosCandidatosCompetencias(){
        return candidatoCompetenciaService.listarTodosCandidatosCompetencias()
    }

    @RequestMapping(value = "/excluir/{$id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void excluirCandidatoCompetencia(int id){
        candidatoCompetenciaService.excluirCandidatoCompetencia(id)
    }
}
