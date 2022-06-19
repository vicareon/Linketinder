export class Candidato {
  nome: string;
  email: string;
  estado: string;
  pais: string;
  cep: string;
  idade: string;
  cpf: string;
  formacaoAcademica: string;
  descricao: string;
  senha: string;

  constructor(nome: string, email: string, estado: string, pais: string, cep: string, idade: string, cpf: string, formacaoAcademica: string, descricao: string, senha: string) {
    this.nome = nome;
    this.email = email;
    this.estado = estado;
    this.pais = pais;
    this.cep = cep;
    this.idade = idade;
    this.cpf = cpf;
    this.formacaoAcademica = formacaoAcademica;
    this.descricao = descricao;
    this.senha = senha;
  }
}
