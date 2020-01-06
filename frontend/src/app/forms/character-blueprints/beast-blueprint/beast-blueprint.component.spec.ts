import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BeastBlueprintComponent } from './beast-blueprint.component';

describe('BeastBlueprintComponent', () => {
  let component: BeastBlueprintComponent;
  let fixture: ComponentFixture<BeastBlueprintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BeastBlueprintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BeastBlueprintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
