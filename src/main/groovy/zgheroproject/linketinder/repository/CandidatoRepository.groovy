package zgheroproject.linketinder.repository

import zgheroproject.linketinder.dao.CandidatoDAO
import zgheroproject.linketinder.model.Candidato
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class CandidatoRepository implements CandidatoDAO {
    @PersistenceContext
    EntityManager entityManager

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

    @Override
    List<Candidato> buscarCandidato(String buscaCpf) {
        return entityManager.createQuery("SELECT c FROM Candidato c WHERE c.cpf = 'buscaCpf'").setParameter('buscaCpf', buscaCpf).getResultList()
    }

    @Transactional
    @Override
    void excluirCandidato(String buscaCpf) {
        entityManager.createQuery("DELETE FROM Candidato WHERE cpf LIKE :buscaCpf").setParameter("buscaCpf", buscaCpf).executeUpdate()
    }
}