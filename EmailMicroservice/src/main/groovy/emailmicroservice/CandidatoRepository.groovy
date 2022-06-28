package emailmicroservice

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CandidatoRepository extends CrudRepository<Candidato, String> {
    List<Candidato> findAll()
}