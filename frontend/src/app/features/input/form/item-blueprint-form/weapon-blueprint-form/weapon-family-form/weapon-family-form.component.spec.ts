import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WeaponFamilyFormComponent } from './weapon-family-form.component';

describe('WeaponFamilyFormComponent', () => {
  let component: WeaponFamilyFormComponent;
  let fixture: ComponentFixture<WeaponFamilyFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WeaponFamilyFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WeaponFamilyFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
