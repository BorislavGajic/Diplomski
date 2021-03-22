import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MagacionerSidebarComponent } from './magacioner-sidebar.component';

describe('MagacionerSidebarComponent', () => {
  let component: MagacionerSidebarComponent;
  let fixture: ComponentFixture<MagacionerSidebarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MagacionerSidebarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MagacionerSidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
