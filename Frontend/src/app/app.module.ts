import { RouterModule } from '@angular/router';

import { HttpClientModule } from '@angular/common/http';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CandidatoComponent } from './pessoaFisica/candidato/candidato.component';
import { EmpresaComponent } from './pessoaJuridica/empresa/empresa.component';
import { CadastroCandidatoComponent } from './pessoaFisica/cadastro-candidato/cadastro-candidato.component';
import { CadastroEmpresaComponent } from './pessoaJuridica/cadastro-empresa/cadastro-empresa.component';
import { CadastroVagaComponent } from './pessoaJuridica/cadastro-vaga/cadastro-vaga.component';
import { CadastroCompetenciaComponent } from './pessoaFisica/cadastro-competencia/cadastro-competencia.component';
import { ListaVagasComponent } from './pessoaFisica/lista-vagas/lista-vagas.component';
import { ListaCandidatosComponent } from './pessoaJuridica/lista-candidatos/lista-candidatos.component';
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
    CadastroCompetenciaComponent,
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
                {path: 'candidato/cadastro/competencia', component: CadastroCompetenciaComponent},
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
