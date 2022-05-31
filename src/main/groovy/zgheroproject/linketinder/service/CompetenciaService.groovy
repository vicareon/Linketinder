package zgheroproject.linketinder.service


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import zgheroproject.linketinder.model.Competencia
import zgheroproject.linketinder.repository.CompetenciaRepository

@Service
class CompetenciaService {
    @Autowired
    private CompetenciaRepository competenciaRepository

    Competencia inserirCompetencia(Competencia competencia){
        return competenciaRepository.inserirCompetencia(competencia)
    }
}