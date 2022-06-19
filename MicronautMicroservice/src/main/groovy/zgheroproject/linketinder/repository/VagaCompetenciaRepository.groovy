package zgheroproject.linketinder.repository

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import zgheroproject.linketinder.model.VagaCompetencia

@Repository
interface VagaCompetenciaRepository extends CrudRepository<VagaCompetencia, Integer>{
    VagaCompetencia save(VagaCompetencia vagaCompetencia)
    List<VagaCompetencia> findAll()
    void deleteById(int id)
}