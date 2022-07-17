package zgheroproject.linketinder.model

import lombok.Data

import javax.persistence.*

@Entity
@Data
@Table(name = "candidatos", schema = "public")
class Candidato{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_candidato")
    public int idCandidato

    @Column(name = "nome_candidato")
    public String nomeCandidato

    @Column(name = "email_candidato")
    public String emailCandidato

    @Column(name = "cep_candidato")
    public String cepCandidato

    @Column(name = "estado_candidato")
    public String estadoCandidato

    @Column(name = "pais_candidato")
    public String paisCandidato

    @Column(name = "descricao_candidato")
    public String descricaoCandidato

    @Column(name = "cpf")
    public String cpf

    @Column(name = "formacao_candidato")
    public String formacaoCandidato

    @Column(name = "idade")
    public String idade

    @Column(name = "senha_candidato")
    public String senhaCandidato

    Candidato(String nomeCandidato, String emailCandidato, String cepCandidato, String estadoCandidato, String paisCandidato, String descricaoCandidato, String cpf, String formacaoCandidato, String idade, String senhaCandidato) {
        this.nomeCandidato = nomeCandidato
        this.emailCandidato = emailCandidato
        this.cepCandidato = cepCandidato
        this.estadoCandidato = estadoCandidato
        this.paisCandidato = paisCandidato
        this.descricaoCandidato = descricaoCandidato
        this.cpf = cpf
        this.formacaoCandidato = formacaoCandidato
        this.idade = idade
        this.senhaCandidato = senhaCandidato
    }

    Candidato() {
    }
}