package zgheroproject.linketinder.controller

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import zgheroproject.linketinder.service.EmpresaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import zgheroproject.linketinder.model.Empresa

@Controller
@ComponentScan(basePackages = "zgheroproject.linketinder.service")
class EmpresaController{
    @Autowired
    EmpresaService empresaService

    @Bean
    EmpresaController initEmpresaController(){
        return new EmpresaController()
    }

    Empresa inserirEmpresa(Empresa empresa) {
        return empresaService.inserirEmpresa(empresa)
    }

    List<Empresa> buscarEmpresa(String buscaCnpj){
        return empresaService.buscarEmpresa(buscaCnpj)
    }
}