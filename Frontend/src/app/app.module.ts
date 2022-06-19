import { RouterModule } from '@angular/router';

import { HttpClientModule } from '@angular/common/http';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CandidatoComponent } from './candidato/candidatoIndex/candidatoIndex.component';
import { EmpresaComponent } from './empresa/empresaIndex/empresaIndex.component';
import { CadastroCandidatoComponent } from './candidato/cadastroCandidato/cadastroCandidato.component';
import { CadastroEmpresaComponent } from './empresa/cadastroEmpresa/cadastroEmpresa.component';
import { CadastroVagaComponent } from './empresa/cadastroVaga/cadastroVaga.component';
import { ListaVagasComponent } from './candidato/listaVagas/listaVagas.component';
import { ListaCandidatosComponent } from './empresa/listaCandidatos/listaCandidatos.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { IndexComponent } from './index/index.component';

@NgModule({
  declarations: [
    AppComponent,
    CandidatoComponent,
    EmpresaComponent,
    CadastroCandidatoComponent,
    CadastroEmpresaComponent,
    CadastroVagaComponent,
    ListaVagasComponent,
    ListaCandidatosComponent,
    IndexComponent
  ],
    imports: [
        BrowserModule,
        RouterModule.forRoot([
                {path: 'candidato', component: CandidatoComponent},
                {path: 'empresa', component: EmpresaComponent},
                {path: 'candidato/cadastro', component: CadastroCandidatoComponent},
                {path: 'empresa/cadastro', component: CadastroEmpresaComponent},
                {path: 'empresa/cadastro/vaga', component: CadastroVagaComponent},
                {path: 'candidato/vagas', component: ListaVagasComponent},
                {path: 'empresa/candidatos', component: ListaCandidatosComponent},
                {path: '', component: IndexComponent}
            ]
        ),
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
