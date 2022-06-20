package zgheroproject.linketinder.model

import lombok.Data

import javax.persistence.*

@Entity
@Data
@Table(name = "candidatos", schema = "public")
class Candidato{
    @GeneratedValue(strategy=GenerationType.AUTO)
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

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
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

    String getCpf() {
        return cpf
    }

    void setCpf(String cpf) {
        this.cpf = cpf
    }

    String getFormacao() {
        return formacao
    }

    void setFormacao(String formacao) {
        this.formacao = formacao
    }

    String getIdade() {
        return idade
    }

    void setIdade(String idade) {
        this.idade = idade
    }

    String getSenha() {
        return senha
    }

    void setSenha(String senha) {
        this.senha = senha
    }
}