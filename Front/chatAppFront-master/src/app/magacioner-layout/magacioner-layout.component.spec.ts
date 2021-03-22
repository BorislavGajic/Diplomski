import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MagacionerLayoutComponent } from './magacioner-layout.component';

describe('MagacionerLayoutComponent', () => {
  let component: MagacionerLayoutComponent;
  let fixture: ComponentFixture<MagacionerLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MagacionerLayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MagacionerLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
