import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarInputComponent } from './navbar-input.component';

describe('NavbarInputComponent', () => {
  let component: NavbarInputComponent;
  let fixture: ComponentFixture<NavbarInputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavbarInputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
