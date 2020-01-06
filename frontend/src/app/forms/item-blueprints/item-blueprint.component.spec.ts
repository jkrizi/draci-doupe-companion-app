import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemBlueprintComponent } from './item-blueprint.component';

describe('ItemBlueprintComponent', () => {
  let component: ItemBlueprintComponent;
  let fixture: ComponentFixture<ItemBlueprintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItemBlueprintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemBlueprintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
