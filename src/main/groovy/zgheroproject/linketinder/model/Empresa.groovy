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
@Table(name = "empresas")
class Empresa{
    //criar nova tabela
    //colocar em ordem
    e
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
}