package zgheroproject.linketinder.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service
import zgheroproject.linketinder.model.Empresa
import zgheroproject.linketinder.repository.EmpresaRepository

@Service
@ComponentScan(basePackages = "zgheroproject.linketinder.repository")
class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository

    @Bean
    EmpresaService initEmpresaService(){
        return new EmpresaService()
    }

    Empresa inserirEmpresa(Empresa empresa){
        return empresaRepository.inserirEmpresa(empresa)
    }

    List<Empresa> buscarEmpresa(String buscaCnpj){
        return empresaRepository.buscarEmpresa(buscaCnpj)
    }
}
