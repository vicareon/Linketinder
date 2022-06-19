import { Component, OnInit } from '@angular/core';
import { Candidato } from "./candidato";
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-cadastro-candidato',
  templateUrl: './cadastro-candidato.component.html',
  styleUrls: ['../index/index.component.css']
})

export class CadastroCandidatoComponent implements OnInit {
  nome: any;
  email: any;
  estado: any;
  pais: any;
  cep: any;
  idade: any;
  cpf: any;
  formacaoAcademica: any;
  descricao: any;
  senha: any;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  onSubmit() {
    const candidato = new Candidato(this.nome, this.email, this.estado, this.pais, this.cep, this.idade, this.cpf, this.formacaoAcademica, this.descricao, this.senha)
    console.log(candidato.nome)
    this.http.post('http://localhost:8080/cadastro/candidato', candidato).subscribe(
      resultado => {
        alert("Candidato cadastrado com sucesso!")
      }
    )
  }
}
