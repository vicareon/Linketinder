package zgheroproject.linketinder.dao

import zgheroproject.linketinder.model.CandidatoCompetencia

interface CandidatoCompetenciaDAO {
    CandidatoCompetencia inserirCandidatoCompetencia(CandidatoCompetencia candidatoCompetencia)
    List<CandidatoCompetencia> listarCompetenciasCandidatos()
    List<CandidatoCompetencia> buscarCandidatoCompetencia(String buscaCpf, String nomeBuscaCompetencia)
}
