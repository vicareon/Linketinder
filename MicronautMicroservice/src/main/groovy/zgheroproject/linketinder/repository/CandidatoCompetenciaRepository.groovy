package zgheroproject.linketinder.repository

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import zgheroproject.linketinder.model.CandidatoCompetencia

@Repository
interface CandidatoCompetenciaRepository extends CrudRepository<CandidatoCompetencia, Integer>{
    CandidatoCompetencia save(CandidatoCompetencia candidatoCompetencia)
    List<CandidatoCompetencia> findAll()
    List<CandidatoCompetencia> findByIdCandidatoCompetencia(int id)
    void deleteByIdCandidatoCompetencia(int id)
}