import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Candidato} from "../../candidato/cadastroCandidato/candidato";

@Component({
  selector: 'app-lista-candidatos',
  templateUrl: './listaCandidatos.component.html',
  styleUrls: ['../../index/index.component.css']
})
export class ListaCandidatosComponent implements OnInit {
  listaCandidatos: any[] = []

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get('localhost:8081/candidato/lista').subscribe((data: any)=> {
      data.forEach((element: { nome: any; }) => {
        this.listaCandidatos.push(element)
      });
    });
  }
}
