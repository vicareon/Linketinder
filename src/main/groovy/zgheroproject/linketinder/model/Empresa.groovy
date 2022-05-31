package zgheroproject.linketinder.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "empresas")
class Empresa{
    @Id
    @Column(name = "cnpj_emp")
    private String cnpj

    @Column(name = "nome_emp")
    private String nome

    @Column(name = "email_emp")
    private String email

    @Column(name = "estado_emp")
    private String estado

    @Column(name = "pais_emp")
    private String pais

    @Column(name = "descricao_emp")
    private String descricao

    @Column(name = "senha_emp")
    private String senha

    @Column(name = "cep_emp")
    private String cep

    Empresa(String nome, String email, String cep, String estado, String pais, String descricao, String senha, String cnpj) {
        this.nome = nome
        this.email = email
        this.cep = cep
        this.estado = estado
        this.pais = pais
        this.descricao = descricao
        this.senha = senha
        this.cnpj = cnpj
    }

    Empresa() {

    }

    String getNome() {
        return nome
    }

    void setNome(String nome) {
        this.nome = nome
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    String getCep() {
        return cep
    }

    void setCep(String cep) {
        this.cep = cep
    }

    String getEstado() {
        return estado
    }

    void setEstado(String estado) {
        this.estado = estado
    }

    String getPais() {
        return pais
    }

    void setPais(String pais) {
        this.pais = pais
    }

    String getDescricao() {
        return descricao
    }

    void setDescricao(String descricao) {
        this.descricao = descricao
    }

    String getSenha() {
        return senha
    }

    void setSenha(String senha) {
        this.senha = senha
    }

    String getCnpj() {
        return cnpj
    }

    void setCnpj(String cnpj) {
        this.cnpj = cnpj
    }
}