package zgheroproject.linketinder.controller


import zgheroproject.linketinder.service.EmpresaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import zgheroproject.linketinder.model.Empresa

@Controller
class EmpresaController{
    @Autowired
    EmpresaService empresaService

    Empresa inserirEmpresa(Empresa empresa) {
        return empresaService.inserirEmpresa(empresa)
    }
}