export class Vaga {
  nome: string;
  estado: string;
  empresa: string;
  descricao: string;

  constructor(nome: string, estado: string, empresa: string, descricao: string) {
    this.nome = nome;
    this.estado = estado;
    this.empresa = empresa;
    this.descricao = descricao;
  }
}
