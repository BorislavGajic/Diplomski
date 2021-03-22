import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperaterSidebarComponent } from './operater-sidebar.component';

describe('OperaterSidebarComponent', () => {
  let component: OperaterSidebarComponent;
  let fixture: ComponentFixture<OperaterSidebarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperaterSidebarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperaterSidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
