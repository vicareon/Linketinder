package zgheroproject.linketinder.model

import io.micronaut.data.annotation.*

@MappedEntity
class CandidatoCompetencia {
    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    public int idCandidatoCompetencia

    public int idCandidato

    public int idCompetencia

    CandidatoCompetencia() {
    }

    CandidatoCompetencia(int idCandidato, int idCompetencia) {
        this.idCandidato = idCandidato
        this.idCompetencia = idCompetencia
    }

    int getIdCandidatoCompetencia() {
        return idCandidatoCompetencia
    }

    void setIdCandidatoCompetencia(int idCandidatoCompetencia) {
        this.idCandidatoCompetencia = idCandidatoCompetencia
    }

    int getIdCandidato() {
        return idCandidato
    }

    void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato
    }

    int getIdCompetencia() {
        return idCompetencia
    }

    void setIdCompetencia(int idCompetencia) {
        this.idCompetencia = idCompetencia
    }
}
