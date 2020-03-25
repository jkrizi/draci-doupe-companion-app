import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BeastBlueprintFormComponent } from './beast-blueprint.component';

describe('BeastBlueprintComponent', () => {
  let component: BeastBlueprintFormComponent;
  let fixture: ComponentFixture<BeastBlueprintFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BeastBlueprintFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BeastBlueprintFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
