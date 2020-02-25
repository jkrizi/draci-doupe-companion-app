import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArmorBlueprintInputComponent } from './armor-blueprint-input.component';

describe('ArmorBlueprintInputComponent', () => {
  let component: ArmorBlueprintInputComponent;
  let fixture: ComponentFixture<ArmorBlueprintInputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArmorBlueprintInputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArmorBlueprintInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
