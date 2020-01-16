import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WeaponBlueprintFormComponent } from './weapon-blueprint.component';

describe('WeaponBlueprintComponent', () => {
  let component: WeaponBlueprintFormComponent;
  let fixture: ComponentFixture<WeaponBlueprintFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WeaponBlueprintFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WeaponBlueprintFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
