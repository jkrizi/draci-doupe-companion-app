import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreasureBlueprintFormComponent } from './treasure-blueprint-form.component';

describe('TreasureBlueprintComponent', () => {
  let component: TreasureBlueprintFormComponent;
  let fixture: ComponentFixture<TreasureBlueprintFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreasureBlueprintFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreasureBlueprintFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
