import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-lista-candidatos',
  templateUrl: './lista-candidatos.component.html',
  styleUrls: ['../../index/index.component.css']
})
export class ListaCandidatosComponent implements OnInit {
  listaCandidatos: any[] = []

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }
}
