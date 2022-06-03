import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroCompetenciaComponent } from './cadastro-competencia.component';

describe('CadastroCompetenciaComponent', () => {
  let component: CadastroCompetenciaComponent;
  let fixture: ComponentFixture<CadastroCompetenciaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroCompetenciaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroCompetenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
