package zgheroproject.linketinder.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import zgheroproject.linketinder.model.Empresa

@Repository
interface EmpresaRepository extends CrudRepository<Empresa, String>{
    Empresa save(Empresa empresa)
    List<Empresa> findAll()
    void deleteById(String cnpj)
}

