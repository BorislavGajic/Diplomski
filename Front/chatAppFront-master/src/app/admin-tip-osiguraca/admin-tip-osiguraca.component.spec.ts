import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminTipOsiguracaComponent } from './admin-tip-osiguraca.component';

describe('AdminTipOsiguracaComponent', () => {
  let component: AdminTipOsiguracaComponent;
  let fixture: ComponentFixture<AdminTipOsiguracaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminTipOsiguracaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminTipOsiguracaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
