package zgheroproject.linketinder.repository

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import zgheroproject.linketinder.dao.VagaDAO
import zgheroproject.linketinder.model.Vaga

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class VagaRepository implements VagaDAO{
    @PersistenceContext
    private EntityManager entityManager

    @Transactional
    @Override
    Vaga inserirVaga(Vaga vaga) {
        entityManager.persist(vaga)
        return vaga
    }

    @Override
    List<Vaga[]> listarVagas() {
        return entityManager.createQuery("SELECT v FROM Vaga v").getResultList()
    }
}