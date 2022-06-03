package zgheroproject.linketinder.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="candidatos_competencias")
class CandidatoCompetencia implements Serializable{
    @Id
    @Column(name="id_cnd")
    String cpfCandidato

    @Id
    @Column(name="id_cmp")
    String nomeCompetencia

    CandidatoCompetencia(String cpfCandidato, String nomeCompetencia) {
        this.cpfCandidato = cpfCandidato
        this.nomeCompetencia = nomeCompetencia
    }

    CandidatoCompetencia() {
    }

    String getCpfCandidato() {
        return cpfCandidato
    }

    void setCpfCandidato(String cpfCandidato) {
        this.cpfCandidato = cpfCandidato
    }

    String getNomeCompetencia() {
        return nomeCompetencia
    }

    void setNomeCompetencia(String nomeCompetencia) {
        this.nomeCompetencia = nomeCompetencia
    }
}
