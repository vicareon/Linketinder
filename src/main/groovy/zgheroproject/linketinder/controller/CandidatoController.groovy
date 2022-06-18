package zgheroproject.linketinder.controller

import org.springframework.context.annotation.ComponentScan
import org.springframework.http.HttpStatus
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import zgheroproject.linketinder.model.Candidato
import zgheroproject.linketinder.service.CandidatoService
import org.springframework.beans.factory.annotation.Autowired

@RestController
@CrossOrigin
@RequestMapping(value = "/candidato")
@ComponentScan(basePackages = "zgheroproject.linketinder.service")
class CandidatoController{
    @Autowired
    CandidatoService candidatoService

    @Transactional
    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    void salvarCandidato(@RequestBody Candidato candidato) {
        candidatoService.salvarCandidato(candidato)
    }

    @Transactional
    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<Candidato> listarCandidatos(){
        return candidatoService.listarCandidatos()
    }

    //atualizar

    @Transactional
    @RequestMapping(value = "/excluir", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    void excluirCandidato(@RequestBody String cpf){
        candidatoService.excluirCandidato(cpf)
    }
}