package zgheroproject.linketinder.repository

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import zgheroproject.linketinder.model.Competencia

@Repository
interface CompetenciaRepository extends CrudRepository<Competencia, Integer> {
    Competencia save(Competencia competencia)
    List<Competencia> findAll()
    void deleteById(int id)
}