import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArmorBlueprintFormComponent } from './armor-blueprint.component';

describe('ArmorBlueprintComponent', () => {
  let component: ArmorBlueprintFormComponent;
  let fixture: ComponentFixture<ArmorBlueprintFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArmorBlueprintFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArmorBlueprintFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
