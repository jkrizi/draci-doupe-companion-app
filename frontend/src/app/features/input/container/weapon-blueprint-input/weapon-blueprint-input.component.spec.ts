import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WeaponBlueprintInputComponent } from './weapon-blueprint-input.component';

describe('WeaponBlueprintInputComponent', () => {
  let component: WeaponBlueprintInputComponent;
  let fixture: ComponentFixture<WeaponBlueprintInputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WeaponBlueprintInputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WeaponBlueprintInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
