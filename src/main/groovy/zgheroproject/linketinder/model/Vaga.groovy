package zgheroproject.linketinder.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "vagas", schema = "public")
class Vaga {
    @Id
    long id_vgs

    @Column(name = "nome_vgs")
    private String nome

    @Column(name = "estado_vgs")
    private String estado

    @Column(name = "descricao_vgs")
    private String descricao

    @Column(name = "empresa_vgs")
    private String cnpjEmpresa

    @Column(name = "competencias_vgs")
    private ArrayList<Competencia> listaCompetencias

    Vaga(String nome, String estado, String descricao, String cnpjEmpresa, ArrayList<Competencia> listaCompetencias) {
        this.nome = nome
        this.estado = estado
        this.descricao = descricao
        this.cnpjEmpresa = cnpjEmpresa
        this.listaCompetencias = listaCompetencias
    }

    Vaga(){

    }

    String getNome() {
        return nome
    }

    void setNome(String nome) {
        this.nome = nome
    }

    String getEstado() {
        return estado
    }

    void setEstado(String estado) {
        this.estado = estado
    }

    String getDescricao() {
        return descricao
    }

    void setDescricao(String descricao) {
        this.descricao = descricao
    }

    String getCnpjEmpresa() {
        return cnpjEmpresa
    }

    void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa
    }

    ArrayList<Competencia> getListaCompetencias() {
        return listaCompetencias
    }

    void setListaCompetencias(ArrayList<Competencia> listaCompetencias) {
        this.listaCompetencias = listaCompetencias
    }
}