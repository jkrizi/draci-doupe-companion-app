import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CombatValuesComponent } from './combat-values.component';

describe('CombatValuesComponent', () => {
  let component: CombatValuesComponent;
  let fixture: ComponentFixture<CombatValuesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CombatValuesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CombatValuesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
