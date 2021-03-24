import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminTipMultipolaComponent } from './admin-tip-multipola.component';

describe('AdminTipMultipolaComponent', () => {
  let component: AdminTipMultipolaComponent;
  let fixture: ComponentFixture<AdminTipMultipolaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminTipMultipolaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminTipMultipolaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
