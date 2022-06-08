package zgheroproject.linketinder.controller

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import zgheroproject.linketinder.model.Candidato
import zgheroproject.linketinder.service.CandidatoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
@ComponentScan(basePackages = "zgheroproject.linketinder.service")
class CandidatoController{
    @Autowired
    CandidatoService candidatoService

    @Bean
    CandidatoController initCandidatoController(){
        return new CandidatoController()
    }

    Candidato inserirCandidato(Candidato candidato) {
        return candidatoService.inserirCandidato(candidato)
    }

    List<Candidato> listarCandidatos(){
        return candidatoService.listarCandidatos()
    }

    List<Candidato> buscarCandidato(String buscaCpf){
        return candidatoService.buscarCandidato(buscaCpf)
    }

    void excluirCandidato(String buscaCpf){
        candidatoService.buscarCandidato(buscaCpf)
    }
}