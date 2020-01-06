import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WeaponBlueprintComponent } from './weapon-blueprint.component';

describe('WeaponBlueprintComponent', () => {
  let component: WeaponBlueprintComponent;
  let fixture: ComponentFixture<WeaponBlueprintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WeaponBlueprintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WeaponBlueprintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
