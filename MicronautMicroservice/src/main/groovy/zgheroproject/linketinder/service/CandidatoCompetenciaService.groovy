package zgheroproject.linketinder.service

import jakarta.inject.Inject
import org.springframework.stereotype.Service
import zgheroproject.linketinder.model.CandidatoCompetencia
import zgheroproject.linketinder.repository.CandidatoCompetenciaRepository

@Service
class CandidatoCompetenciaService {
    @Inject
    private CandidatoCompetenciaRepository candidatoCompetenciaRepository

    void salvarCandidatoCompetencia(CandidatoCompetencia candidatoCompetencia){
        candidatoCompetenciaRepository.save(candidatoCompetencia)
    }

    List<CandidatoCompetencia> listarTodosCandidatosCompetencias(){
        return candidatoCompetenciaRepository.findAll()
    }

    void excluirCandidatoCompetencia(int id){
        candidatoCompetenciaRepository.deleteById(id)
    }
}
