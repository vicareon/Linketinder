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
    String cpf

    @Id
    @Column(name="id_cmp")
    String nome

    CandidatoCompetencia(String cpf, String nome) {
        this.cpf = cpf
        this.nome = nome
    }

    CandidatoCompetencia() {
    }

    String getCpf() {
        return cpf
    }

    void setCpf(String cpf) {
        this.cpf = cpf
    }

    String getNome() {
        return nome
    }

    void setNome(String nome) {
        this.nome = nome
    }
}
