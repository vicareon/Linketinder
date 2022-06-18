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
    @RequestMapping(value = "/excluir", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void excluirEmpresa(@RequestBody String cnpj){
        empresaService.excluirEmpresa(cnpj)
    }
}