import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateTipMultipolaComponent } from './admin-create-tip-multipola.component';

describe('AdminCreateTipMultipolaComponent', () => {
  let component: AdminCreateTipMultipolaComponent;
  let fixture: ComponentFixture<AdminCreateTipMultipolaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCreateTipMultipolaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCreateTipMultipolaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
