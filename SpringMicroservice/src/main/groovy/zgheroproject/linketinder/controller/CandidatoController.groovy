package zgheroproject.linketinder.controller

import org.springframework.context.annotation.ComponentScan
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import zgheroproject.linketinder.model.Candidato
import zgheroproject.linketinder.service.CandidatoService
import org.springframework.beans.factory.annotation.Autowired

@RestController
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

    @CrossOrigin
    @Transactional
    @RequestMapping(value = "/atualizar/nome/{cpf}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarNome(@PathVariable("cpf") String cpf, @RequestBody String nome){
        candidatoService.atualizarNome(cpf, nome)
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(value = "/atualizar/email/{cpf}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarEmail(@PathVariable("cpf") String cpf, @RequestBody String email){
        candidatoService.atualizarEmail(cpf, email)
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(value = "/atualizar/cep/{cpf}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarCep(@PathVariable("cpf") String cpf, @RequestBody String cep){
        candidatoService.atualizarCep(cpf, cep)
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(value = "/atualizar/estado/{cpf}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarEstado(@PathVariable("cpf") String cpf, @RequestBody String estado){
        candidatoService.atualizarEstado(cpf, estado)
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(value = "/atualizar/pais/{cpf}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarPais(@PathVariable("cpf") String cpf, @RequestBody String pais){
        candidatoService.atualizarPais(cpf, pais)
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(value = "/atualizar/descricao/{cpf}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarDescricao(@PathVariable("cpf") String cpf, @RequestBody String descricao){
        candidatoService.atualizarDescricao(cpf, descricao)
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(value = "/atualizar/formacao/{cpf}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarFormacao(@PathVariable("cpf") String cpf, @RequestBody String formacao){
        candidatoService.atualizarFormacao(cpf, formacao)
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(value = "/atualizar/idade/{cpf}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarIdade(@PathVariable("cpf") String cpf, @RequestBody String idade){
        candidatoService.atualizarIdade(cpf, idade)
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(value = "/atualizar/senha/{cpf}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarSenha(@PathVariable("cpf") String cpf, @RequestBody String senha){
        candidatoService.atualizarSenha(cpf, senha)
    }

    @Transactional
    @RequestMapping(value = "/excluir", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void excluirCandidato(@RequestBody String cpf){
        candidatoService.excluirCandidato(cpf)
    }
}