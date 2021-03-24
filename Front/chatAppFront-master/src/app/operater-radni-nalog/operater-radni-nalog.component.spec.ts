import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterRadniNalogComponent } from './operater-radni-nalog.component';

describe('OperaterRadniNalogComponent', () => {
  let component: OperaterRadniNalogComponent;
  let fixture: ComponentFixture<OperaterRadniNalogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperaterRadniNalogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperaterRadniNalogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
