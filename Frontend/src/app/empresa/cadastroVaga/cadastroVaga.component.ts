import { Component, OnInit } from '@angular/core';
import {Competencia} from "../../candidato/cadastroCandidato/competencia";
import {newArray} from "@angular/compiler/src/util";

@Component({
  selector: 'app-cadastro-vaga',
  templateUrl: './cadastroVaga.component.html',
  styleUrls: ['../../index/index.component.css']
})
export class CadastroVagaComponent implements OnInit {
  nome: any;
  estado: any;
  descricao: any;
  competencias: any;
  cnpj: any;

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit() {
    let competencias = []



  }
}
