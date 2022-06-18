package zgheroproject.linketinder.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Data

@Entity
@Data
@Table(name="candidatos_competencias")
class CandidatoCompetencia {
    @Id
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
}
