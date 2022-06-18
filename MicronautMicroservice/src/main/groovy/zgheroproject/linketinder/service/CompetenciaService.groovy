package zgheroproject.linketinder.service

import jakarta.inject.Inject
import org.springframework.stereotype.Service
import zgheroproject.linketinder.model.Competencia
import zgheroproject.linketinder.repository.CompetenciaRepository

@Service
class CompetenciaService {
    @Inject
    private CompetenciaRepository competenciaRepository

    void salvarCompetencia(Competencia competencia){
        competenciaRepository.save(competencia)
    }

    List<Competencia> listarCompetencias(){
        return competenciaRepository.findAll()
    }

    void excluirCompetencia(String nome){
        competenciaRepository.deleteById(nome)
    }
}
