import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BeastBlueprintListComponent } from './beast-blueprint-list.component';

describe('BeastBlueprintListComponent', () => {
  let component: BeastBlueprintListComponent;
  let fixture: ComponentFixture<BeastBlueprintListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BeastBlueprintListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BeastBlueprintListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
