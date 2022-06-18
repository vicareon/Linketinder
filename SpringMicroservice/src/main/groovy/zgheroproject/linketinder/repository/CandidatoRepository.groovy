package zgheroproject.linketinder.repository

import org.springframework.data.repository.CrudRepository
import zgheroproject.linketinder.model.Candidato
import org.springframework.stereotype.Repository

@Repository
interface CandidatoRepository extends CrudRepository<Candidato, String>{
    Candidato save(Candidato candidato)
    List<Candidato> findAll()
    void deleteById(String cpf)
}