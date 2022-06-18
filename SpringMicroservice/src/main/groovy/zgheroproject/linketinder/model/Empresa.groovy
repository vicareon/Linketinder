package zgheroproject.linketinder.model

import lombok.Data

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Data
@Table(name = "empresas", schema = "public")
class Empresa{
    @Column(name = "id")
    public int id

    @Column(name = "nome")
    public String nome

    @Column(name = "email")
    public String email

    @Column(name = "cep")
    public String cep

    @Column(name = "estado")
    public String estado

    @Column(name = "pais")
    public String pais

    @Column(name = "descricao")
    public String descricao

    @Id
    @Column(name = "cnpj")
    public String cnpj

    @Column(name = "senha")
    public String senha

    Empresa(String nome, String email, String cep, String estado, String pais, String descricao, String cnpj, String senha) {
        this.nome = nome
        this.email = email
        this.cep = cep
        this.estado = estado
        this.pais = pais
        this.descricao = descricao
        this.cnpj = cnpj
        this.senha = senha
    }

    Empresa() {
    }
}