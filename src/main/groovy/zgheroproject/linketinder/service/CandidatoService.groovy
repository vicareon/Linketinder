package zgheroproject.linketinder.service

import zgheroproject.linketinder.model.Candidato
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import zgheroproject.linketinder.repository.CandidatoRepository

@Service
class CandidatoService{
    @Autowired
    private CandidatoRepository candidatoRepository

    Candidato inserirCandidato(Candidato candidato){
        return candidatoRepository.inserirCandidato(candidato)
    }

    List<Candidato> listarCandidatos(){
        return candidatoRepository.listarCandidatos()
    }
}