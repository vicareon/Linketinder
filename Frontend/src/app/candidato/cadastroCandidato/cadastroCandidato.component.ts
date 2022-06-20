import { Component, OnInit } from '@angular/core';
import { Candidato } from "./candidato";
import {HttpClient} from '@angular/common/http';
import {Competencia} from "./competencia";
import {CandidatoCompetencia} from "./candidatoCompetencia";

@Component({
  selector: 'app-cadastro-candidato',
  templateUrl: './cadastroCandidato.component.html',
  styleUrls: ['../../index/index.component.css']
})

export class CadastroCandidatoComponent implements OnInit {
  nome: any;
  email: any;
  estado: any;
  pais: any;
  cep: any;
  idade: any;
  cpf: any;
  formacao: any;
  descricao: any;
  senha: any;

  competencia: any;
  listaCompetencias: any[] = []

  constructor(private http: HttpClient) { }

  postCandidato(){
    const candidato = new Candidato(this.nome, this.email, this.estado, this.pais, this.cep, this.idade, this.cpf, this.formacao, this.descricao, this.senha)
    console.log(candidato.nome)
    this.http.post('http://localhost:8081/candidato/cadastro', candidato).subscribe(
      resultado => {
        alert("Candidato cadastrado com sucesso!")
      }
    )
  }

  postCompetencia(){
    const competencia = new Competencia(this.competencia)
    this.http.post('http://localhost:8082/competencia/cadastro', competencia).subscribe(
      resultado => {
        alert("Competência cadastrada com sucesso!")
      }
    )
  }

  postCandidatoCompetencia(){
    const candidatoCompetencia = new CandidatoCompetencia(this.cpf, this.competencia)
    this.http.post('http://localhost:8082/competencia/candidato/cadastro', candidatoCompetencia).subscribe(
      resultado => {
        alert("Competência do candidato cadastrada com sucesso!")
      }
    )
  }

  ngOnInit(): void {
    this.http.get('http://localhost:8082/competencia/lista').subscribe((data: any)=> {
      data.forEach((element: { nome: any; }) => {
        this.listaCompetencias.push(element)
      });
    });
  }

  onSubmit() {
    this.postCandidato()
    this.postCompetencia()
    this.postCandidatoCompetencia()
  }
}
