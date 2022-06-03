export class Empresa {
  nome: string;
  email: string;
  estado: string;
  pais: string;
  cep: string;
  cnpj: string;
  descricao: string;
  senha: string;


  constructor(nome: string, email: string, estado: string, pais: string, cep: string, cnpj: string, descricao: string, senha: string) {
    this.nome = nome;
    this.email = email;
    this.estado = estado;
    this.pais = pais;
    this.cep = cep;
    this.cnpj = cnpj;
    this.descricao = descricao;
    this.senha = senha;
  }
}
