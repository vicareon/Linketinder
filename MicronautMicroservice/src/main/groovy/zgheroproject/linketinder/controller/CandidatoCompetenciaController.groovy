package zgheroproject.linketinder.controller

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import zgheroproject.linketinder.model.CandidatoCompetencia
import zgheroproject.linketinder.repository.CandidatoCompetenciaRepository

import javax.inject.Inject

@Controller("/competencia/candidato")
class CandidatoCompetenciaController {
    @Inject
    private CandidatoCompetenciaRepository candidatoCompetenciaRepository

    @Post("/cadastro")
    void salvarCompetencia(@Body CandidatoCompetencia candidatoCompetencia){
        candidatoCompetenciaRepository.save(candidatoCompetencia)
    }

    @Get("/lista")
    List<CandidatoCompetencia> listarCompetencias(){
        return candidatoCompetenciaRepository.findAll()
    }

    @Delete("/excluir/{id}")
    void excluirCompetencia(@PathVariable("id") int id){
        candidatoCompetenciaRepository.deleteById(id)
    }
}