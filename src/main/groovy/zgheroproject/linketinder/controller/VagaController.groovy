package zgheroproject.linketinder.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Controller
import zgheroproject.linketinder.model.Empresa
import zgheroproject.linketinder.model.Vaga
import zgheroproject.linketinder.service.VagaService

@Controller
@ComponentScan(basePackages = "zgheroproject.linketinder.service")
class VagaController{
    @Autowired
    VagaService vagaService

    @Bean
    VagaController initVagaController(){
        return new VagaController()
    }

    Empresa inserirEmpresa(Empresa empresa) {
        return empresaService.inserirEmpresa(empresa)
    }

    List<Vaga[]> listarVagas(){
        return vagaService.listarVagas()
    }
}