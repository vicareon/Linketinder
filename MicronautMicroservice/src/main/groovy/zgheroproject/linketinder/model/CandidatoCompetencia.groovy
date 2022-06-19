package zgheroproject.linketinder.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "candidatos_competencias")
class CandidatoCompetencia {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    public int id

    @Column(name="cpf")
    public String cpf

    @Column(name="competencia")
    public String competencia

    CandidatoCompetencia(int id, String cpf, String competencia) {
        this.id = id
        this.cpf = cpf
        this.competencia = competencia
    }

    CandidatoCompetencia() {
    }

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getCpf() {
        return cpf
    }

    void setCpf(String cpf) {
        this.cpf = cpf
    }

    String getCompetencia() {
        return competencia
    }

    void setCompetencia(String competencia) {
        this.competencia = competencia
    }
}
