import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreasureBlueprintComponent } from './treasure-blueprint.component';

describe('TreasureBlueprintComponent', () => {
  let component: TreasureBlueprintComponent;
  let fixture: ComponentFixture<TreasureBlueprintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreasureBlueprintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreasureBlueprintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
