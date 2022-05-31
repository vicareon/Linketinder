package zgheroproject.linketinder.microservice

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
import zgheroproject.linketinder.model.Empresa

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@RestController
@RequestMapping("/cadastro")
@SpringBootApplication
@EntityScan(basePackages = "com.example.model")
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
}