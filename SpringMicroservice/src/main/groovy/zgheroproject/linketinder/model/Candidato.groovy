package zgheroproject.linketinder.model

import lombok.Data

import javax.persistence.*

@Entity
@Data
@Table(name = "candidatos", schema = "public")
class Candidato{
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
    @Column(name = "cpf")
    public String cpf

    @Column(name = "formacao")
    public String formacao

    @Column(name = "idade")
    public String idade

    @Column(name = "senha")
    public String senha

    Candidato(String nome, String email, String cep, String estado, String pais, String descricao, String cpf, String formacao, String idade, String senha) {
        this.nome = nome
        this.email = email
        this.cep = cep
        this.estado = estado
        this.pais = pais
        this.descricao = descricao
        this.cpf = cpf
        this.formacao = formacao
        this.idade = idade
        this.senha = senha
    }

    Candidato() {
    }
}