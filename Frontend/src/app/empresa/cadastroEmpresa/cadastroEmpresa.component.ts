import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Empresa} from "./empresa";

@Component({
  selector: 'app-cadastro-empresa',
  templateUrl: './cadastroEmpresa.component.html',
  styleUrls: ['../../index/index.component.css']
})
export class CadastroEmpresaComponent implements OnInit {
  nome: any
  email: any
  cep: any
  estado: any
  pais: any
  descricao: any
  cnpj: any
  senha: any

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  onSubmit() {
    const empresa = new Empresa(this.nome, this.email, this.cep, this.estado, this.pais, this.descricao, this.cnpj, this.senha)
    this.http.post('http://localhost:8081/empresa/cadastro', empresa).subscribe(
      resultado => {
        alert("Empresa cadastrada com sucesso!")
      }
    )
  }
}
