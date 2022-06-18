package zgheroproject.linketinder.controller

import jakarta.inject.Inject
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import zgheroproject.linketinder.model.VagaCompetencia
import zgheroproject.linketinder.service.VagaCompetenciaService

@RestController("/competencia/vaga")
class VagaCompetenciaController {
    @Inject
    private VagaCompetenciaService vagaCompetenciaService

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    void salvarVagaCompetencia(VagaCompetencia vagaCompetencia){
        vagaCompetenciaService.salvarVagaCompetencia(vagaCompetencia)
    }

    @RequestMapping(value = "/lista", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    List<VagaCompetencia> listarTodasVagasCompetencias(){
        return vagaCompetenciaService.listarTodasVagasCompetencias()
    }

    @RequestMapping(value = "/excluir/{$id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    void excluirVagaCompetencia(int id){
        vagaCompetenciaService.excluirVagaCompetencia(id)
    }
}
