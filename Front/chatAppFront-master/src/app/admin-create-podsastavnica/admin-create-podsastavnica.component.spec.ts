import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreatePodsastavnicaComponent } from './admin-create-podsastavnica.component';

describe('AdminCreatePodsastavnicaComponent', () => {
  let component: AdminCreatePodsastavnicaComponent;
  let fixture: ComponentFixture<AdminCreatePodsastavnicaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCreatePodsastavnicaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCreatePodsastavnicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
