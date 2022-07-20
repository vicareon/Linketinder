package zgheroproject.linketinder.model

import io.micronaut.data.annotation.*

@MappedEntity
class VagaCompetencia {
    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    public int idVagaCompetencia

    public int idVaga

    public int idCompetencia

    VagaCompetencia(int idVaga, int idCompetencia) {
        this.idVaga = idVaga
        this.idCompetencia = idCompetencia
    }

    VagaCompetencia() {
    }

    int getIdVaga() {
        return idVaga
    }

    void setIdVaga(int idVaga) {
        this.idVaga = idVaga
    }

    int getIdCompetencia() {
        return idCompetencia
    }

    void setIdCompetencia(int idCompetencia) {
        this.idCompetencia = idCompetencia
    }
}
