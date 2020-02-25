import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArmorBlueprintListComponent } from './armor-blueprint-list.component';

describe('ArmorBlueprintListComponent', () => {
  let component: ArmorBlueprintListComponent;
  let fixture: ComponentFixture<ArmorBlueprintListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArmorBlueprintListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArmorBlueprintListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
