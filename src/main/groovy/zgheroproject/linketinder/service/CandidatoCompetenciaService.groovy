package zgheroproject.linketinder.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import zgheroproject.linketinder.model.CandidatoCompetencia
import zgheroproject.linketinder.repository.CandidatoCompetenciaRepository

@Service
class CandidatoCompetenciaService {
    @Autowired
    private CandidatoCompetenciaRepository candidatoCompetenciaRepository

    CandidatoCompetencia inserirCandidatoCompetencia(CandidatoCompetencia candidatoCompetencia){
        return candidatoCompetenciaRepository.inserirCandidatoCompetencia(candidatoCompetencia)
    }
}