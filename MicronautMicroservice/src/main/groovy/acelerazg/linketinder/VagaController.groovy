package acelerazg.linketinder


import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("/vaga")
class VagaController {
    @Inject
    private VagaRepository vagaRepository

    VagaController(VagaRepository vagaRepository){
        this.vagaRepository = vagaRepository
    }

    @Post
    HttpResponse<?> salvarVaga(@Body Vaga vaga){
        this.vagaRepository.save(vaga)
        return HttpResponse.status(HttpStatus.CREATED)
    }

    @Get("/lista")
    HttpResponse<?> listarVagas(){
        return HttpResponse.ok(vagaRepository.findAll())
    }
}