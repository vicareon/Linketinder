import {Competencia} from "../cadastro-competencia/competencia";

export class Vaga {
  nome: string;
  estado: string;
  descricao: string;
  cnpj: string;
  listaCompetencias: Competencia[];

  constructor(nome: string, estado: string, descricao: string, cnpj: string, listaCompetencias: Competencia[]) {
    this.nome = nome;
    this.estado = estado;
    this.descricao = descricao;
    this.cnpj = cnpj;
    this.listaCompetencias = listaCompetencias;
  }
}
