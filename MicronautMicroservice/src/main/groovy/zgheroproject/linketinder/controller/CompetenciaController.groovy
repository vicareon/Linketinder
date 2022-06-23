package zgheroproject.linketinder.controller

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import zgheroproject.linketinder.model.Competencia
import zgheroproject.linketinder.repository.CompetenciaRepository

import javax.inject.Inject

@Controller("/competencia")
class CompetenciaController {
    @Inject
    private CompetenciaRepository competenciaRepository

    @Post("/cadastro")
    void salvarCompetencia(@Body Competencia competencia){
        competenciaRepository.save(competencia)
    }

    @Get("/lista")
    List<Competencia> listarCompetencias(){
        return competenciaRepository.findAll()
    }

    @Delete("/excluir/{id}")
    void excluirCompetencia(@PathVariable("id") int id){
        competenciaRepository.deleteById(id)
    }
}