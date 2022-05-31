package zgheroproject.linketinder.repository


import zgheroproject.linketinder.model.Competencia
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import zgheroproject.linketinder.dao.CompetenciaDAO

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class CompetenciaRepository implements CompetenciaDAO{
    @PersistenceContext
    private EntityManager entityManager

    @Transactional
    @Override
    Competencia inserirCompetencia(Competencia competencia) {
        entityManager.persist(competencia)
        return competencia
    }
}
