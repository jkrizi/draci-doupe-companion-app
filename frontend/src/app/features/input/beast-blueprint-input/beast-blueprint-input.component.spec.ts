import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BeastBlueprintInputComponent } from './beast-blueprint-input.component';

describe('BeastBlueprintInputComponent', () => {
  let component: BeastBlueprintInputComponent;
  let fixture: ComponentFixture<BeastBlueprintInputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BeastBlueprintInputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BeastBlueprintInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
