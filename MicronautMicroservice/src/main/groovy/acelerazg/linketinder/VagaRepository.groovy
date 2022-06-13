package acelerazg.linketinder

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface VagaRepository extends CrudRepository<Vaga, Long>{
    Vaga save(Vaga vaga)
    List<Vaga> findAll()
}