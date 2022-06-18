package zgheroproject.linketinder.controller

import jakarta.inject.Inject
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import zgheroproject.linketinder.model.Competencia
import zgheroproject.linketinder.service.CompetenciaService

@RestController("/competencia")
class CompetenciaController {
    @Inject
    private CompetenciaService competenciaService

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    void salvarCompetencia(Competencia competencia){
        competenciaService.salvarCompetencia(competencia)
    }

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<Competencia> listarCompetencias(){
        return competenciaService.listarCompetencias()
    }

    @RequestMapping(value = "/excluir/{$nome}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void excluirCompetencia(String nome){
        competenciaService.excluirCompetencia(nome)
    }
}
