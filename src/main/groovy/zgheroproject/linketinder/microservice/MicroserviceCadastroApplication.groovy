package zgheroproject.linketinder.microservice

import org.springframework.web.bind.annotation.CrossOrigin
import zgheroproject.linketinder.model.Candidato
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.http.HttpStatus
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import zgheroproject.linketinder.model.CandidatoCompetencia
import zgheroproject.linketinder.model.Competencia
import zgheroproject.linketinder.model.Empresa

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@RestController
@CrossOrigin
@RequestMapping("/cadastro")
@SpringBootApplication
@EntityScan(basePackages = "zgheroproject.linketinder.model")
class MicroserviceCadastroApplication {
    static void main(String[] args) {
        SpringApplication.run(MicroserviceCadastroApplication, args)
    }

    @PersistenceContext
    private EntityManager entityManager

    @Transactional
    @RequestMapping(value = "/candidato", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Candidato inserirCandidato(@RequestBody Candidato candidato) {
        entityManager.persist(candidato)
        return candidato
    }

    @Transactional
    @RequestMapping(value = "/empresa", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Empresa inserirEmpresa(@RequestBody Empresa empresa) {
        entityManager.persist(empresa)
        return empresa
    }

    /*@Transactional
    @RequestMapping(value = "/empresa/vaga", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Vaga inserirVaga(@RequestBody Vaga vaga) {
        entityManager.persist(vaga)
        return vaga
    }*/

    @Transactional
    @RequestMapping(value = "/candidato/competencia", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    CandidatoCompetencia inserirCandidatoCompetencia(@RequestBody CandidatoCompetencia candidatoCompetencia) {
        entityManager.persist(candidatoCompetencia)
        return candidatoCompetencia
    }

    @Transactional
    @RequestMapping(value = "/candidato/cria-competencia", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Competencia inserirCompetencia(@RequestBody Competencia competencia) {
        entityManager.persist(competencia)
        return competencia
    }

    @Transactional
    @RequestMapping(value = "/lista/competencia", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<Competencia> listarCompetencias() {
        return entityManager.createQuery("SELECT c FROM Competencia c").getResultList()
    }

    @Transactional
    @RequestMapping(value = "/lista/candidatos", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<Candidato> listarCandidatos() {
        return entityManager.createQuery("SELECT c FROM Candidato c").getResultList()
    }
}