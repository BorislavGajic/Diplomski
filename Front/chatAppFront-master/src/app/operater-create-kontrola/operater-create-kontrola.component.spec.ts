import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterCreateKontrolaComponent } from './operater-create-kontrola.component';

describe('OperaterCreateKontrolaComponent', () => {
  let component: OperaterCreateKontrolaComponent;
  let fixture: ComponentFixture<OperaterCreateKontrolaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperaterCreateKontrolaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperaterCreateKontrolaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
