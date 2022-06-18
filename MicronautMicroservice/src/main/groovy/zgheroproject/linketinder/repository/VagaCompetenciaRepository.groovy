package zgheroproject.linketinder.repository

import io.micronaut.data.annotation.Repository
import org.springframework.data.repository.CrudRepository
import zgheroproject.linketinder.model.VagaCompetencia

@Repository
interface VagaCompetenciaRepository extends CrudRepository<VagaCompetencia, Integer>{
    VagaCompetencia save(VagaCompetencia vagaCompetencia)
    VagaCompetencia update(VagaCompetencia vagaCompetencia)
    List<VagaCompetencia> findAll()
    void delete(VagaCompetencia vagaCompetencia)
    void deleteById(int id)
}