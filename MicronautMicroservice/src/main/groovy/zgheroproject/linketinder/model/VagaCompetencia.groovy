package zgheroproject.linketinder.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="vagas_competencias")
class VagaCompetencia {
    @Id
    @Column(name="id")
    public int id

    @Column(name="id_vaga")
    public int id_vaga

    @Column(name="competencia")
    public String competencia

    VagaCompetencia(int id, int id_vaga, String competencia) {
        this.id = id
        this.id_vaga = id_vaga
        this.competencia = competencia
    }

    VagaCompetencia() {

    }

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    int getId_vaga() {
        return id_vaga
    }

    void setId_vaga(int id_vaga) {
        this.id_vaga = id_vaga
    }

    String getCompetencia() {
        return competencia
    }

    void setCompetencia(String competencia) {
        this.competencia = competencia
    }
}
