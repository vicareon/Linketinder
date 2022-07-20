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

    List<Empresa> retornarEmpresaPorCnpj(String cnpj){
        return empresaRepository.findByCnpj(cnpj)
    }

    void excluirEmpresa(String cnpj){
        empresaRepository.deleteByCnpj(cnpj)
    }

    void atualizarNome(String cnpj, String nome){
        empresaRepository.atualizarNome(cnpj, nome)
    }

    void atualizarEmail(String cnpj, String email){
        empresaRepository.atualizarEmail(cnpj, email)
    }

    void atualizarCep(String cnpj, String cep){
        empresaRepository.atualizarCep(cnpj, cep)
    }

    void atualizarEstado(String cnpj, String estado){
        empresaRepository.atualizarEstado(cnpj, estado)
    }

    void atualizarPais(String cnpj, String pais){
        empresaRepository.atualizarPais(cnpj, pais)
    }

    void atualizarDescricao(String cnpj, String descricao){
        empresaRepository.atualizarDescricao(cnpj, descricao)
    }

    void atualizarSenha(String cnpj, String senha){
        empresaRepository.atualizarSenha(cnpj, senha)
    }

    boolean verificarExistenciaEmpresaPorCnpj(String cnpj){
        return empresaRepository.existsByCnpj(cnpj)
    }
}
