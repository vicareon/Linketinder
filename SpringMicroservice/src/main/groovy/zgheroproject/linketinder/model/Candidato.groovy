package zgheroproject.linketinder.model

import javax.persistence.*

@Entity
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

    String getNomeCandidato() {
        return nomeCandidato
    }

    void setNomeCandidato(String nomeCandidato) {
        this.nomeCandidato = nomeCandidato
    }

    String getEmailCandidato() {
        return emailCandidato
    }

    void setEmailCandidato(String emailCandidato) {
        this.emailCandidato = emailCandidato
    }

    String getCepCandidato() {
        return cepCandidato
    }

    void setCepCandidato(String cepCandidato) {
        this.cepCandidato = cepCandidato
    }

    String getEstadoCandidato() {
        return estadoCandidato
    }

    void setEstadoCandidato(String estadoCandidato) {
        this.estadoCandidato = estadoCandidato
    }

    String getPaisCandidato() {
        return paisCandidato
    }

    void setPaisCandidato(String paisCandidato) {
        this.paisCandidato = paisCandidato
    }

    String getDescricaoCandidato() {
        return descricaoCandidato
    }

    void setDescricaoCandidato(String descricaoCandidato) {
        this.descricaoCandidato = descricaoCandidato
    }

    String getCpf() {
        return cpf
    }

    void setCpf(String cpf) {
        this.cpf = cpf
    }

    String getFormacaoCandidato() {
        return formacaoCandidato
    }

    void setFormacaoCandidato(String formacaoCandidato) {
        this.formacaoCandidato = formacaoCandidato
    }

    String getIdade() {
        return idade
    }

    void setIdade(String idade) {
        this.idade = idade
    }

    String getSenhaCandidato() {
        return senhaCandidato
    }

    void setSenhaCandidato(String senhaCandidato) {
        this.senhaCandidato = senhaCandidato
    }
}