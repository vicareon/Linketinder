package zgheroproject.linketinder.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="competencias")
class Competencia {
    @Id
    @Column(name="id")
    public int id

    @Column(name="nome")
    public String nome

    Competencia(int id, String nome) {
        this.id = id
        this.nome = nome
    }

    Competencia() {

    }

    String getNome() {
        return nome
    }

    void setNome(String nome) {
        this.nome = nome
    }

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }
}
