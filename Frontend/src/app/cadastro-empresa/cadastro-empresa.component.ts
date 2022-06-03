import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Empresa} from "./empresa";

@Component({
  selector: 'app-cadastro-empresa',
  templateUrl: './cadastro-empresa.component.html',
  styleUrls: ['./cadastro-empresa.component.css']
})
export class CadastroEmpresaComponent implements OnInit {
  nome: any;
  email: any;
  estado: any;
  pais: any;
  cep: any;
  cnpj: any;
  descricao: any;
  senha: any;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  onSubmit() {
    const empresa = new Empresa(this.nome, this.email, this.estado, this.pais, this.cep, this.cnpj, this.descricao, this.senha)
    this.http.post('http://localhost:8080/cadastro/empresa', empresa).subscribe(
      resultado => {
        alert("Empresa cadastrada com sucesso!")
      }
    )
  }
}
