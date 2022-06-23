package zgheroproject.linketinder.controller

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import zgheroproject.linketinder.model.VagaCompetencia
import zgheroproject.linketinder.repository.VagaCompetenciaRepository

import javax.inject.Inject


@Controller("/competencia/vaga")
class VagaCompetenciaController {
    @Inject
    private VagaCompetenciaRepository vagaCompetenciaRepository

    @Post("/cadastro")
    void salvarVagaCompetencia(@Body VagaCompetencia vagaCompetencia){
        vagaCompetenciaRepository.save(vagaCompetencia)
    }

    @Get("/lista")
    List<VagaCompetencia> listarTodasVagasCompetencias(){
        return vagaCompetenciaRepository.findAll()
    }

    @Delete("/excluir/{id}")
    void excluirVagaCompetencia(@PathVariable("id") int id){
        vagaCompetenciaRepository.deleteById(id)
    }
}
