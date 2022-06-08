package zgheroproject.linketinder.service

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import zgheroproject.linketinder.model.Candidato
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import zgheroproject.linketinder.repository.CandidatoRepository

@Service
@ComponentScan(basePackages = "zgheroproject.linketinder.repository")
class CandidatoService{
    @Autowired
    CandidatoRepository candidatoRepository

    @Bean
    CandidatoService initCandidatoService(){
        return new CandidatoService()
    }

    Candidato inserirCandidato(Candidato candidato){
        return candidatoRepository.inserirCandidato(candidato)
    }

    List<Candidato> listarCandidatos(){
        return candidatoRepository.listarCandidatos()
    }

    List<Candidato> buscarCandidato(String buscaCpf){
        return candidatoRepository.buscarCandidato(buscaCpf)
    }

    void excluirCandidato(String buscaCpf){
        candidatoRepository.buscarCandidato(buscaCpf)
    }
}