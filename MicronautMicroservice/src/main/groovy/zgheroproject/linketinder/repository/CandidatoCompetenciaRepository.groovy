package zgheroproject.linketinder.repository

import io.micronaut.data.annotation.Repository
import org.springframework.data.repository.CrudRepository
import zgheroproject.linketinder.model.CandidatoCompetencia

@Repository
interface CandidatoCompetenciaRepository extends CrudRepository<CandidatoCompetencia, int>{
    CandidatoCompetencia save(CandidatoCompetencia candidatoCompetencia)
    CandidatoCompetencia update(CandidatoCompetencia candidatoCompetencia)
    List<CandidatoCompetencia> findAll()
    //Optional<CandidatoCompetencia> findById(Integer id)
    //void delete(CandidatoCompetencia candidatoCompetencia)
    void deleteById(int id)
}