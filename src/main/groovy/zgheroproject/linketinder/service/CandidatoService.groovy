package zgheroproject.linketinder.service

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

    void salvarCandidato(Candidato candidato){
        candidatoRepository.save(candidato)
    }

    List<Candidato> listarCandidatos(){
        return candidatoRepository.findAll()
    }

    void excluirCandidato(String cpf){
        candidatoRepository.deleteById(cpf)
    }
}