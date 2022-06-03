package zgheroproject.linketinder.repository

import org.springframework.data.jpa.repository.Query
import zgheroproject.linketinder.dao.CandidatoDAO
import zgheroproject.linketinder.model.Candidato
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.repository.CrudRepository

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class CandidatoRepository implements CandidatoDAO {
    @PersistenceContext
    private EntityManager entityManager

    @Transactional
    @Override
    Candidato inserirCandidato(Candidato candidato) {
        entityManager.persist(candidato)
        return candidato
    }

    @Override
    List<Candidato> listarCandidatos(){
        return entityManager.createQuery("SELECT c FROM Candidato c").getResultList()
    }
}