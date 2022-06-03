package zgheroproject.linketinder.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import zgheroproject.linketinder.model.Empresa
import zgheroproject.linketinder.model.Vaga
import zgheroproject.linketinder.service.EmpresaService
import zgheroproject.linketinder.service.VagaService

@Controller
class VagaController{
    @Autowired
    VagaService vagaService

    Empresa inserirEmpresa(Empresa empresa) {
        return empresaService.inserirEmpresa(empresa)
    }

    List<Vaga[]> listarVagas(){
        return vagaService.listarVagas()
    }
}