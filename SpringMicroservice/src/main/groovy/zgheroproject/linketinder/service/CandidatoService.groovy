package zgheroproject.linketinder.service

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import zgheroproject.linketinder.model.Candidato
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import zgheroproject.linketinder.repository.CandidatoRepository

@Service
@ComponentScan(basePackages = "zgheroproject.linketinder.repository")
class CandidatoService{
    @Autowired
    CandidatoRepository candidatoRepository

    @Bean
    CandidatoService candidatoServiceInit(){
        return new CandidatoService()
    }

    void salvarCandidato(Candidato candidato){
        candidatoRepository.save(candidato)
    }

    List<Candidato> listarCandidatos(){
        return candidatoRepository.findAll()
    }

    List<Candidato> retornarCandidatoPorCpf(String cpf){
        return candidatoRepository.findByCpf(cpf)
    }

    boolean verificarExistenciaCandidatoPorCpf(String cpf){
        return candidatoRepository.existsByCpf(cpf)
    }

    void excluirCandidato(String cpf){
        candidatoRepository.deleteByCpf(cpf)
    }

    void atualizarNome(String cpf, String nome){
        candidatoRepository.atualizarNome(cpf, nome)
    }

    void atualizarEmail(String cpf, String email){
        candidatoRepository.atualizarEmail(cpf, email)
    }

    void atualizarCep(String cpf, String cep){
        candidatoRepository.atualizarCep(cpf, cep)
    }

    void atualizarEstado(String cpf, String estado){
        candidatoRepository.atualizarEstado(cpf, estado)
    }

    void atualizarPais(String cpf, String pais){
        candidatoRepository.atualizarPais(cpf, pais)
    }

    void atualizarDescricao(String cpf, String descricao){
        candidatoRepository.atualizarDescricao(cpf, descricao)
    }

    void atualizarFormacao(String cpf, String formacao){
        candidatoRepository.atualizarFormacao(cpf, formacao)
    }

    void atualizarIdade(String cpf, String idade){
        candidatoRepository.atualizarIdade(cpf, idade)
    }

    void atualizarSenha(String cpf, String senha){
        candidatoRepository.atualizarSenha(cpf, senha)
    }
}