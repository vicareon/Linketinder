package zgheroproject.linketinder.model

import lombok.Data

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Data
@Table(name = "empresas", schema = "public")
class Empresa{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_empresa")
    public int idEmpresa

    @Column(name = "nome_empresa")
    public String nomeEmpresa

    @Column(name = "email_empresa")
    public String emailEmpresa

    @Column(name = "cep_empresa")
    public String cepEmpresa

    @Column(name = "estado_empresa")
    public String estadoEmpresa

    @Column(name = "pais_empresa")
    public String paisEmpresa

    @Column(name = "descricao_empresa")
    public String descricaoEmpresa

    @Column(name = "cnpj")
    public String cnpj

    @Column(name = "senha_empresa")
    public String senhaEmpresa

    Empresa(String nomeEmpresa, String emailEmpresa, String cepEmpresa, String estadoEmpresa, String paisEmpresa, String descricaoEmpresa, String cnpj, String senhaEmpresa) {
        this.nomeEmpresa = nomeEmpresa
        this.emailEmpresa = emailEmpresa
        this.cepEmpresa = cepEmpresa
        this.estadoEmpresa = estadoEmpresa
        this.paisEmpresa = paisEmpresa
        this.descricaoEmpresa = descricaoEmpresa
        this.cnpj = cnpj
        this.senhaEmpresa = senhaEmpresa
    }

    Empresa() {
    }
}