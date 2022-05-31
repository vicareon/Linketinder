package zgheroproject.linketinder.dao


import zgheroproject.linketinder.model.Empresa

interface EmpresaDAO {
    //void listarEmpresas()
    Empresa inserirEmpresa(Empresa empresa)
    /*void deletarEmpresa(String cnpj)
    void atualizarEmpresa(String buscaCnpj, int escolhaAtualizarEmpresa, String dadoAtualizado)

    void atualizarNome(String nomeAtualizado, String buscaCnpj)
    void atualizarEmail(String emailAtualizado, String buscaCnpj)
    void atualizarCep(String cepAtualizado, String buscaCnpj)
    void atualizarEstado(String estadoAtualizado, String buscaCnpj)
    void atualizarPais(String paisAtualizado, String buscaCnpj)
    void atualizarDescricao(String descricaoAtualizada, String buscaCnpj)
    void atualizarSenha(String senhaAtualizada, String buscaCnpj)*/
}