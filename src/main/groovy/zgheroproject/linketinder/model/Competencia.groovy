package zgheroproject.linketinder.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "competencias", schema = "public")
class Competencia implements Serializable{
    @Id
    @Column(name = "nome_cmp")
    String nome

    Competencia(String nome) {
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
}