package zgheroproject.linketinder.repository

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import zgheroproject.linketinder.dao.CandidatoCompetenciaDAO
import zgheroproject.linketinder.model.CandidatoCompetencia

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class CandidatoCompetenciaRepository implements CandidatoCompetenciaDAO{
    @PersistenceContext
    private EntityManager entityManager

    @Transactional
    @Override
    CandidatoCompetencia inserirCandidatoCompetencia(CandidatoCompetencia candidatoCompetencia) {
        entityManager.persist(candidatoCompetencia)
        return candidatoCompetencia
    }
}