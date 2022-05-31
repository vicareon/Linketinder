package zgheroproject.linketinder.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import zgheroproject.linketinder.model.Empresa
import zgheroproject.linketinder.service.EmpresaService

@Controller
class VagaController{
    @Autowired
    EmpresaService empresaService

    Empresa inserirEmpresa(Empresa empresa) {
        return empresaService.inserirEmpresa(empresa)
    }
}