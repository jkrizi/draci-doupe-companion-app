import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreasureBlueprintListComponent } from './treasure-blueprint-list.component';

describe('TreasureBlueprintListComponent', () => {
  let component: TreasureBlueprintListComponent;
  let fixture: ComponentFixture<TreasureBlueprintListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreasureBlueprintListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreasureBlueprintListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
