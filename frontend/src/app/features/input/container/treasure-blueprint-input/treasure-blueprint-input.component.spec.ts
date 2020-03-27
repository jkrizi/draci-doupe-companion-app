import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreasureBlueprintInputComponent } from './treasure-blueprint-input.component';

describe('TreasureBlueprintInputComponent', () => {
  let component: TreasureBlueprintInputComponent;
  let fixture: ComponentFixture<TreasureBlueprintInputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreasureBlueprintInputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreasureBlueprintInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
