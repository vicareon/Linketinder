export class Empresa {
  nome: string;
  email: string;
  cep: string;
  estado: string;
  pais: string;
  descricao: string;
  cnpj: string;
  senha: string;

  constructor(nome: string, email: string, cep: string, estado: string, pais: string, descricao: string, cnpj: string, senha: string) {
    this.nome = nome;
    this.email = email;
    this.cep = cep;
    this.estado = estado;
    this.pais = pais;
    this.descricao = descricao;
    this.cnpj = cnpj;
    this.senha = senha;
  }
}
