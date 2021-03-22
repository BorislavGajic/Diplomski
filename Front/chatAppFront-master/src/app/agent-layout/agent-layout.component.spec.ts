import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentLayoutComponent } from './agent-layout.component';

describe('AgentLayoutComponent', () => {
  let component: AgentLayoutComponent;
  let fixture: ComponentFixture<AgentLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentLayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
