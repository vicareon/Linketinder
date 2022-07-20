package zgheroproject.linketinder

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import spock.lang.Specification
import zgheroproject.linketinder.model.Candidato
import zgheroproject.linketinder.model.Empresa
import zgheroproject.linketinder.service.CandidatoService
import zgheroproject.linketinder.service.EmpresaService

@SpringBootTest
@ComponentScan(basePackages = "zgheroproject.linketinder.*")
class EmpresaServiceSpec extends Specification{
    @Autowired
    EmpresaService empresaService

    def "Teste com inserção de candidato retorna true"(){
        setup:
        Empresa empresa = new Empresa("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CNPJ", "senha")

        when:
        empresaService.salvarEmpresa(empresa)
        boolean resultadoTeste = empresaService.verificarExistenciaEmpresaPorCnpj("Teste CNPJ")

        then:
        resultadoTeste
        empresaService.excluirEmpresa("Teste CNPJ")
    }

    def "Teste com inserção de candidato retorna false"(){
        setup:
        Empresa empresa = new Empresa("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", " ", "senha")

        when:
        empresaService.salvarEmpresa(empresa)
        boolean resultadoTeste = empresaService.verificarExistenciaEmpresaPorCnpj("Teste CNPJ")

        then:
        !resultadoTeste
        empresaService.excluirEmpresa(" ")
    }

    def "Teste de lista de empresa"(){
        setup:
        Empresa empresa = new Empresa("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CNPJ", "senha")

        when:
        empresaService.salvarEmpresa(empresa)
        int resultadoTeste = empresaService.listarEmpresas().size()

        then:
        resultadoTeste == 6
        empresaService.excluirEmpresa("Teste CNPJ")
    }

    def "Teste de atualização de nome"(){
        setup:
        Empresa empresa = new Empresa("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CNPJ", "senha")

        when:
        empresaService.salvarEmpresa(empresa)
        empresaService.atualizarNome("Teste CNPJ", "Novo Nome")

        then:
        empresaService.retornarEmpresaPorCnpj("Teste CNPJ").get(0).getNomeEmpresa().equals("Novo Nome")
        empresaService.excluirEmpresa("Teste CNPJ")
    }

    def "Teste de atualização de email"(){
        setup:
        Empresa empresa = new Empresa("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CNPJ", "senha")

        when:
        empresaService.salvarEmpresa(empresa)
        empresaService.atualizarEmail("Teste CNPJ", "Novo Email")

        then:
        empresaService.retornarEmpresaPorCnpj("Teste CNPJ").get(0).getEmailEmpresa().equals("Novo Email")
        empresaService.excluirEmpresa("Teste CNPJ")
    }

    def "Teste de atualização de cep"(){
        setup:
        Empresa empresa = new Empresa("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CNPJ", "senha")

        when:
        empresaService.salvarEmpresa(empresa)
        empresaService.atualizarCep("Teste CNPJ", "Novo CEP")

        then:
        empresaService.retornarEmpresaPorCnpj("Teste CNPJ").get(0).getCepEmpresa().equals("Novo CEP")
        empresaService.excluirEmpresa("Teste CNPJ")
    }

    def "Teste de atualização de estado"(){
        setup:
        Empresa empresa = new Empresa("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CNPJ", "senha")

        when:
        empresaService.salvarEmpresa(empresa)
        empresaService.atualizarEstado("Teste CNPJ", "Novo Estado")

        then:
        empresaService.retornarEmpresaPorCnpj("Teste CNPJ").get(0).getEstadoEmpresa().equals("Novo Estado")
        empresaService.excluirEmpresa("Teste CNPJ")
    }

    def "Teste de atualização de país"(){
        setup:
        Empresa empresa = new Empresa("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CNPJ", "senha")

        when:
        empresaService.salvarEmpresa(empresa)
        empresaService.atualizarPais("Teste CNPJ", "Novo País")

        then:
        empresaService.retornarEmpresaPorCnpj("Teste CNPJ").get(0).getPaisEmpresa().equals("Novo País")
        empresaService.excluirEmpresa("Teste CNPJ")
    }

    def "Teste de atualização de descrição"(){
        setup:
        Empresa empresa = new Empresa("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CNPJ", "senha")

        when:
        empresaService.salvarEmpresa(empresa)
        empresaService.atualizarDescricao("Teste CNPJ", "Nova Descrição")

        then:
        empresaService.retornarEmpresaPorCnpj("Teste CNPJ").get(0).getDescricaoEmpresa().equals("Nova Descrição")
        empresaService.excluirEmpresa("Teste CNPJ")
    }

    def "Teste de atualização de senha"(){
        setup:
        Empresa empresa = new Empresa("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CNPJ", "senha")

        when:
        empresaService.salvarEmpresa(empresa)
        empresaService.atualizarSenha("Teste CNPJ", "teste")

        then:
        empresaService.retornarEmpresaPorCnpj("Teste CNPJ").get(0).getSenhaEmpresa().equals("teste")
        empresaService.excluirEmpresa("Teste CNPJ")
    }
}
