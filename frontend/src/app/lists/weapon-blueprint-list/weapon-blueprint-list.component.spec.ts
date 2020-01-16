import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WeaponBlueprintListComponent } from './weapon-blueprint-list.component';

describe('WeaponBlueprintListComponent', () => {
  let component: WeaponBlueprintListComponent;
  let fixture: ComponentFixture<WeaponBlueprintListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WeaponBlueprintListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WeaponBlueprintListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
