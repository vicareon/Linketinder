package zgheroproject.linketinder

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import spock.lang.Specification
import zgheroproject.linketinder.model.Candidato
import zgheroproject.linketinder.repository.CandidatoRepository
import zgheroproject.linketinder.service.CandidatoService

@SpringBootTest
@ComponentScan(basePackages = "zgheroproject.linketinder.*")
class CandidatoServiceSpec extends Specification{
    @Autowired
    CandidatoService candidatoService

    def "Teste com inserção de candidato retorna true"(){
        setup:
        Candidato candidato = new Candidato("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CPF", "Teste Formação", "99", "teste")

        when:
        candidatoService.salvarCandidato(candidato)
        boolean resultadoTeste = candidatoService.verificarExistenciaCandidatoPorCpf("Teste CPF")

        then:
        resultadoTeste
        candidatoService.excluirCandidato("Teste CPF")
    }

    def "Teste com inserção de candidato retorna false"(){
        setup:
        Candidato candidato = new Candidato("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", " ", "Teste Formação", "99", "teste")

        when:
        candidatoService.salvarCandidato(candidato)
        boolean resultadoTeste = candidatoService.verificarExistenciaCandidatoPorCpf("Teste CPF")

        then:
        !resultadoTeste
        candidatoService.excluirCandidato(" ")
    }

    def "Teste de lista de candidato"(){
        setup:
        Candidato candidato = new Candidato("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CPF", "Teste Formação", "99", "teste")

        when:
        candidatoService.salvarCandidato(candidato)
        int resultadoTeste = candidatoService.listarCandidatos().size()

        then:
        resultadoTeste == 1
        candidatoService.excluirCandidato("Teste CPF")
    }

    def "Teste de atualização de nome"(){
        setup:
        Candidato candidato = new Candidato("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CPF", "Teste Formação", "99", "teste")

        when:
        candidatoService.salvarCandidato(candidato)
        candidatoService.atualizarNome("Teste CPF", "Novo Nome")

        then:
        candidatoService.retornarCandidatoPorCpf("Teste CPF").get(0).getNomeCandidato().equals("Novo Nome")
        candidatoService.excluirCandidato("Teste CPF")
    }

    def "Teste de atualização de email"(){
        setup:
        Candidato candidato = new Candidato("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CPF", "Teste Formação", "99", "teste")

        when:
        candidatoService.salvarCandidato(candidato)
        candidatoService.atualizarEmail("Teste CPF", "Novo Email")

        then:
        candidatoService.retornarCandidatoPorCpf("Teste CPF").get(0).getEmailCandidato().equals("Novo Email")
        candidatoService.excluirCandidato("Teste CPF")
    }

    def "Teste de atualização de cep"(){
        setup:
        Candidato candidato = new Candidato("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CPF", "Teste Formação", "99", "teste")

        when:
        candidatoService.salvarCandidato(candidato)
        candidatoService.atualizarCep("Teste CPF", "Novo CEP")

        then:
        candidatoService.retornarCandidatoPorCpf("Teste CPF").get(0).getCepCandidato().equals("Novo CEP")
        candidatoService.excluirCandidato("Teste CPF")
    }

    def "Teste de atualização de estado"(){
        setup:
        Candidato candidato = new Candidato("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CPF", "Teste Formação", "99", "teste")

        when:
        candidatoService.salvarCandidato(candidato)
        candidatoService.atualizarEstado("Teste CPF", "Novo Estado")

        then:
        candidatoService.retornarCandidatoPorCpf("Teste CPF").get(0).getEstadoCandidato().equals("Novo Estado")
        candidatoService.excluirCandidato("Teste CPF")
    }

    def "Teste de atualização de país"(){
        setup:
        Candidato candidato = new Candidato("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CPF", "Teste Formação", "99", "teste")

        when:
        candidatoService.salvarCandidato(candidato)
        candidatoService.atualizarPais("Teste CPF", "Novo País")

        then:
        candidatoService.retornarCandidatoPorCpf("Teste CPF").get(0).getPaisCandidato().equals("Novo País")
        candidatoService.excluirCandidato("Teste CPF")
    }

    def "Teste de atualização de descrição"(){
        setup:
        Candidato candidato = new Candidato("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CPF", "Teste Formação", "99", "teste")

        when:
        candidatoService.salvarCandidato(candidato)
        candidatoService.atualizarDescricao("Teste CPF", "Nova Descrição")

        then:
        candidatoService.retornarCandidatoPorCpf("Teste CPF").get(0).getDescricaoCandidato().equals("Nova Descrição")
        candidatoService.excluirCandidato("Teste CPF")
    }

    def "Teste de atualização de formação"(){
        setup:
        Candidato candidato = new Candidato("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CPF", "Teste Formação", "99", "teste")

        when:
        candidatoService.salvarCandidato(candidato)
        candidatoService.atualizarFormacao("Teste CPF", "Nova Formação")

        then:
        candidatoService.retornarCandidatoPorCpf("Teste CPF").get(0).getFormacaoCandidato().equals("Nova Formação")
        candidatoService.excluirCandidato("Teste CPF")
    }

    def "Teste de atualização de idade"(){
        setup:
        Candidato candidato = new Candidato("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CPF", "Teste Formação", "99", "teste")

        when:
        candidatoService.salvarCandidato(candidato)
        candidatoService.atualizarIdade("Teste CPF", "21")

        then:
        candidatoService.retornarCandidatoPorCpf("Teste CPF").get(0).getIdade().equals("21")
        candidatoService.excluirCandidato("Teste CPF")
    }

    def "Teste de atualização de senha"(){
        setup:
        Candidato candidato = new Candidato("Teste Nome", "Teste Email", "Teste CEP", "Teste Estado", "Teste País", "Teste Descrição", "Teste CPF", "Teste Formação", "99", "teste")

        when:
        candidatoService.salvarCandidato(candidato)
        candidatoService.atualizarSenha("Teste CPF", "senha")

        then:
        candidatoService.retornarCandidatoPorCpf("Teste CPF").get(0).getSenhaCandidato().equals("senha")
        candidatoService.excluirCandidato("Teste CPF")
    }
}
