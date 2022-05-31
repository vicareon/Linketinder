package zgheroproject.linketinder.repository

import zgheroproject.linketinder.dao.CandidatoDAO
import zgheroproject.linketinder.model.Candidato
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class CandidatoRepository implements CandidatoDAO{
    @PersistenceContext
    private EntityManager entityManager

    @Transactional
    @Override
    Candidato inserirCandidato(Candidato candidato) {
        entityManager.persist(candidato)
        return candidato
    }
}