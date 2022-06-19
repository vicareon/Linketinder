import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CandidatoCompetencia} from "./candidatoCompetencia"
import {Competencia} from "./competencia";

@Component({
  selector: 'app-cadastro-competencia',
  templateUrl: './cadastro-competencia.component.html',
  styleUrls: ['../../index/index.component.css']
})
export class CadastroCompetenciaComponent implements OnInit {
  nome: any;
  cpf: any;
  listaCompetencias: any[] = []

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.http.get('http://localhost:8082/competencia/lista').subscribe((data: any)=> {
      data.forEach((element: { nome: any; }) => {
        this.listaCompetencias.push(element)
      });
    });
  }

  onSubmit() {
    const competencia = new Competencia(this.nome)
    this.http.post('http://localhost:8082/competencia/cadastro', competencia).subscribe(
      resultado => {
        alert("Competência cadastrada com sucesso!")
      }
    )

    const candidatoCompetencia = new CandidatoCompetencia(this.cpf, this.nome)
    this.http.post('http://localhost:8082/competencia/candidato/cadastro', candidatoCompetencia).subscribe(
      resultado => {
        alert("Competência do candidato cadastrada com sucesso!")
      }
    )
  }
}
