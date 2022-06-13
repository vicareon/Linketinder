package acelerazg.linketinder

import io.micronaut.core.annotation.Introspected
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Column

@Entity
@Table(name = "vagas")
@Introspected
class Vaga{
    @Id
    long id_vgs

    @Column(name = "nome_vgs")
    private String nome

    @Column(name = "estado_vgs")
    private String estado

    @Column(name = "descricao_vgs")
    private String descricao

    @Column(name = "empresa_vgs")
    private String cnpj

    @Column(name = "competencias_vgs")
    private ArrayList listaCompetencias

    Vaga(String nome, String estado, String descricao, String cnpjEmpresa, ArrayList listaCompetencias) {
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

    ArrayList getListaCompetencias() {
        return listaCompetencias
    }

    void setListaCompetencias(ArrayList listaCompetencias) {
        this.listaCompetencias = listaCompetencias
    }
}