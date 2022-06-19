package zgheroproject.linketinder.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "competencias")
class Competencia {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
