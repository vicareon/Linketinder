package zgheroproject.linketinder.dao

import zgheroproject.linketinder.model.Candidato

interface CandidatoDAO {
    //void listarCandidatos()
    Candidato inserirCandidato(Candidato candidato)
    List<Candidato> listarCandidatos()
    void excluirCandidato(String buscaCpf)
    List<Candidato> buscarCandidato(String buscaCpf)

    /*void atualizarCandidato(String buscaCpf, int escolhaAtualizaCandidato, String dadoAtualizado)

    void atualizarNome(String nome, String buscaCpf)
    void atualizarEmail(String email, String buscaCpf)
    void atualizarCep(String cep, String buscaCpf)
    void atualizarEstado(String estado, String buscaCpf)
    void atualizarPais(String pais, String buscaCpf)
    void atualizarDescricao(String descricao, String buscaCpf)
    void atualizarFormacaoAcademica(String formacaoAcademica, String buscaCpf)
    void atualizarIdade(int idade, String buscaCpf)
    void atualizarSenha(String senha, String buscaCpf)*/
}