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

    @Override
    List<CandidatoCompetencia> listarCompetenciasCandidatos(){
        return entityManager.createQuery("SELECT c FROM CandidatoCompetencia c").getResultList()
    }

    @Override
    List<CandidatoCompetencia> buscarCandidatoCompetencia(String buscaCpf, String nomeBuscaCompetencia) {
        return entityManager.createQuery("SELECT c FROM CandidatoCompetencia c WHERE c.cpf = 'buscaCpf' AND c.nome = 'nomeBuscaCompetencia'").setParameter('buscaCpf', buscaCpf, 'nomeBuscaCompetencia', nomeBuscaCompetencia).getResultList()
    }
}