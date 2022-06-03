package zgheroproject.linketinder.dao


import zgheroproject.linketinder.model.Vaga

interface VagaDAO {
    //void listarVagas()
    Vaga inserirVaga(Vaga vaga)
    List<Vaga[]> listarVagas()
    /*void deletarVaga(String cnpj)
    void atualizarVaga(String buscaCnpj, int escolhaAtualizarVaga, String dadoAtualizado)

    boolean buscarCnpjEmpresa(String buscaCnpj)

    void atualizarNome(String nomeAtualizado, String buscaCnpj)
    void atualizarEstado(String estadoAtualizado, String buscaCnpj)
    void atualizarDescricao(String descricaoAtualizada, String buscaCnpj)*/
}