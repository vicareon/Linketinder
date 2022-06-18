package zgheroproject.linketinder.repository

import io.micronaut.data.annotation.Repository
import org.springframework.data.repository.CrudRepository
import zgheroproject.linketinder.model.Competencia

@Repository
interface CompetenciaRepository extends CrudRepository<Competencia, Integer>{
    Competencia save(Competencia competencia)
    Competencia update(Competencia competencia)
    List<Competencia> findAll()
    void delete(Competencia competencia)
    void deleteById(int id)
}