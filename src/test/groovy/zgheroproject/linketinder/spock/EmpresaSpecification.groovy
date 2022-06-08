package zgheroproject.linketinder.spock

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import spock.lang.Specification
import zgheroproject.linketinder.controller.EmpresaController
import zgheroproject.linketinder.model.Empresa

@SpringBootTest
@ComponentScan(basePackages = "zgheroproject.linketinder.*")
class EmpresaSpecification extends Specification{
    @Autowired
    EmpresaController empresaController

    void "Teste de cadastro"() {
        given: "Criação de candidato com parâmetros de teste e inicialização de bean candidatoController"
        def empresa = new Empresa("teste nome", "teste email", "teste cep", "teste estado", "teste país", "teste descrição", "teste senha", "teste cnpj")
        empresaController.initEmpresaController()

        when: "Chamada de método de controller de inserção de empresa"
        empresaController.inserirEmpresa(empresa)

        then: "Verifica se a empresa foi adicionada ao banco de dados"
        empresaController.buscarEmpresa("teste cnpj")
    }
}
