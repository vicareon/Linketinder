import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Vaga} from "./vaga";

@Component({
  selector: 'app-cadastro-vaga',
  templateUrl: './cadastroVaga.component.html',
  styleUrls: ['../../index/index.component.css']
})
export class CadastroVagaComponent implements OnInit {
  nome: any;
  estado: any;
  descricao: any;
  empresa: any;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  onSubmit() {
    const vaga = new Vaga(this.nome, this.estado, this.descricao, this.empresa)
    this.http.post('http://localhost:8081/empresa/cadastro', vaga).subscribe(
      resultado => {
        alert("Vaga cadastrada com sucesso!")
      }
    )
  }
}
