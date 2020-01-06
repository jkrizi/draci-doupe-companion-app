import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArmorBlueprintComponent } from './armor-blueprint.component';

describe('ArmorBlueprintComponent', () => {
  let component: ArmorBlueprintComponent;
  let fixture: ComponentFixture<ArmorBlueprintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArmorBlueprintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArmorBlueprintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
