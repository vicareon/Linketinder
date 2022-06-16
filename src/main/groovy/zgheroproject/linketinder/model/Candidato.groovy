package zgheroproject.linketinder.model

import lombok.Data

import javax.persistence.*

@Entity
@Data
@Table(name = "candidatos")
class Candidato{
    //colocar em ordem

    @Id
    @Column(name = "cpf_cnd")
    private String cpf

    @Column(name = "cep_cnd")
    private String cep

    @Column(name = "nome_cnd")
    private String nome

    @Column(name = "email_cnd")
    private String email

    @Column(name = "estado_cnd")
    private String estado

    @Column(name = "pais_cnd")
    private String pais

    @Column(name = "descricao_cnd")
    private String descricao

    @Column(name = "formacao_cnd")
    private String formacaoAcademica

    @Column(name = "idade_cnd")
    private String idade

    @Column(name = "senha_cnd")
    private String senha

    Candidato(String nome, String email, String cep, String estado, String pais, String descricao, String senha, String cpf, String formacaoAcademica, String idade) {
        this.nome = nome
        this.email = email
        this.cep = cep
        this.estado = estado
        this.pais = pais
        this.descricao = descricao
        this.senha = senha
        this.cpf = cpf
        this.formacaoAcademica = formacaoAcademica
        this.idade = idade
    }

    Candidato() {

    }
}