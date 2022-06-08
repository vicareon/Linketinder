package zgheroproject.linketinder.dao

import zgheroproject.linketinder.model.Competencia

interface CompetenciaDAO {
    //void listarCompetencias()
    Competencia inserirCompetencia(Competencia competencia)
    List<Competencia> listarCompetencias()
    List<Competencia> buscarCompetencia(String nomeBuscaCompetencia)
    /*void deletarCompetencia(String nome)
    void atualizarCompetencia(String nome, String nomeAtualizado)*/
}