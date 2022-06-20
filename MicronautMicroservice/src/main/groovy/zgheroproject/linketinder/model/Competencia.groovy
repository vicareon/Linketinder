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

    @Column(name="competencia")
    public String competencia

    Competencia(int id, String competencia) {
        this.id = id
        this.competencia = competencia
    }

    Competencia() {

    }

    String getCompetencia() {
        return competencia
    }

    void setCompetencia(String competencia) {
        this.competencia = competencia
    }

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }
}
