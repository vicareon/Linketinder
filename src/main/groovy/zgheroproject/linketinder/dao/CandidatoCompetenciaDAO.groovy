package zgheroproject.linketinder.dao

import org.springframework.stereotype.Component
import zgheroproject.linketinder.model.CandidatoCompetencia

@Component
interface CandidatoCompetenciaDAO {
    CandidatoCompetencia inserirCandidatoCompetencia(CandidatoCompetencia candidatoCompetencia)
}
