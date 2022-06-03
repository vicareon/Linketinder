import { Component, OnInit } from '@angular/core';
import {Competencia} from "../cadastro-competencia/competencia";
import {newArray} from "@angular/compiler/src/util";

@Component({
  selector: 'app-cadastro-vaga',
  templateUrl: './cadastro-vaga.component.html',
  styleUrls: ['./cadastro-vaga.component.css']
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
