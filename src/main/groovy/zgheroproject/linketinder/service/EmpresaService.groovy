package zgheroproject.linketinder.service


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import zgheroproject.linketinder.model.Empresa
import zgheroproject.linketinder.repository.EmpresaRepository

@Service
class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository

    Empresa inserirEmpresa(Empresa empresa){
        return empresaRepository.inserirEmpresa(empresa)
    }
}
