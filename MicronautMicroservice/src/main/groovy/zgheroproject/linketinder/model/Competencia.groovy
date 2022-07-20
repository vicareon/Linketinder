package zgheroproject.linketinder.model

import io.micronaut.data.annotation.*

@MappedEntity
class Competencia {
    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    public int idCompetencia

    public String nomeCompetencia

    Competencia() {
    }

    Competencia(String nomeCompetencia) {
        this.nomeCompetencia = nomeCompetencia
    }

    String getNomeCompetencia() {
        return nomeCompetencia
    }

    void setNomeCompetencia(String nomeCompetencia) {
        this.nomeCompetencia = nomeCompetencia
    }
}
