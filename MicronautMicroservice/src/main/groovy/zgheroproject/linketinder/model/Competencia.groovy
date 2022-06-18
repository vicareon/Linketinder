package zgheroproject.linketinder.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="competencias")
class Competencia {
    @Column(name="id")
    public int id

    @Id
    @Column(name="nome")
    public String nome

    Competencia(int id, String nome) {
        this.id = id
        this.nome = nome
    }

    Competencia() {

    }
}
