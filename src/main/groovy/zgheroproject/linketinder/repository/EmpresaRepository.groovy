package zgheroproject.linketinder.repository

import zgheroproject.linketinder.dao.EmpresaDAO
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import zgheroproject.linketinder.model.Empresa

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class EmpresaRepository implements EmpresaDAO{
    @PersistenceContext
    private EntityManager entityManager

    @Transactional
    @Override
    Empresa inserirEmpresa(Empresa empresa) {
        entityManager.persist(empresa)
        return empresa
    }

    @Override
    List<Empresa> listarEmpresas(){
        return entityManager.createQuery("SELECT e FROM Empresa e").getResultList()
    }

    @Override
    List<Empresa> buscarEmpresa(String buscaCnpj) {
        return entityManager.createQuery("SELECT e FROM Empresa e WHERE e.cnpj LIKE :buscaCnpj").setParameter("buscaCnpj", buscaCnpj).getResultList()
    }
}
