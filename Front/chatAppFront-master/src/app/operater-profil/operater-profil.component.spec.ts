import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterProfilComponent } from './operater-profil.component';

describe('OperaterProfilComponent', () => {
  let component: OperaterProfilComponent;
  let fixture: ComponentFixture<OperaterProfilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperaterProfilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperaterProfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
