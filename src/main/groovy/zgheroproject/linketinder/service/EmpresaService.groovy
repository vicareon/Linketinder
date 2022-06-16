package zgheroproject.linketinder.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service
import zgheroproject.linketinder.model.Empresa
import zgheroproject.linketinder.repository.EmpresaRepository

@Service
@ComponentScan(basePackages = "zgheroproject.linketinder.repository")
class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository

    void salvarEmpresa(Empresa empresa){
        empresaRepository.save(empresa)
    }

    List<Empresa> listarEmpresas(){
        return empresaRepository.findAll()
    }

    void excluirEmpresa(String cnpj){
        empresaRepository.deleteById(cnpj)
    }
}
