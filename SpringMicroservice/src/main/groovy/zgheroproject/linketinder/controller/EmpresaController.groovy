package zgheroproject.linketinder.controller

import org.springframework.context.annotation.ComponentScan
import org.springframework.http.HttpStatus
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import zgheroproject.linketinder.model.Empresa
import zgheroproject.linketinder.service.EmpresaService
import org.springframework.beans.factory.annotation.Autowired

@RestController
@CrossOrigin
@RequestMapping(value="/empresa")
@ComponentScan(basePackages = "zgheroproject.linketinder.service")
class EmpresaController{
    @Autowired
    EmpresaService empresaService

    @Transactional
    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    void salvarEmpresa(@RequestBody Empresa empresa){
        empresaService.salvarEmpresa(empresa)
    }

    @Transactional
    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<Empresa> listarEmpresas(){
        return empresaService.listarEmpresas()
    }

    //atualizar
    @Transactional
    @RequestMapping(value = "/atualizar/nome/{cnpj}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarNome(@PathVariable("cnpj") String cnpj, @RequestBody String nome){
        empresaService.atualizarNome(cnpj, nome)
    }

    @Transactional
    @RequestMapping(value = "/atualizar/email/{cnpj}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarEmail(@PathVariable("cnpj") String cnpj, @RequestBody String email){
        empresaService.atualizarEmail(cnpj, email)
    }

    @Transactional
    @RequestMapping(value = "/atualizar/cep/{cnpj}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarCep(@PathVariable("cnpj") String cnpj, @RequestBody String cep){
        empresaService.atualizarCep(cnpj, cep)
    }

    @Transactional
    @RequestMapping(value = "/atualizar/estado/{cnpj}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarEstado(@PathVariable("cnpj") String cnpj, @RequestBody String estado){
        empresaService.atualizarEstado(cnpj, estado)
    }

    @Transactional
    @RequestMapping(value = "/atualizar/pais/{cnpj}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarPais(@PathVariable("cnpj") String cnpj, @RequestBody String pais){
        empresaService.atualizarPais(cnpj, pais)
    }

    @Transactional
    @RequestMapping(value = "/atualizar/descricao/{cnpj}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarDescricao(@PathVariable("cnpj") String cnpj, @RequestBody String descricao){
        empresaService.atualizarDescricao(cnpj, descricao)
    }

    @Transactional
    @RequestMapping(value = "/atualizar/senha/{cnpj}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    void atualizarSenha(@PathVariable("cnpj") String cnpj, @RequestBody String senha){
        empresaService.atualizarSenha(cnpj, senha)
    }

    @Transactional
    @RequestMapping(value = "/excluir", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void excluirEmpresa(@RequestBody String cnpj){
        empresaService.excluirEmpresa(cnpj)
    }
}