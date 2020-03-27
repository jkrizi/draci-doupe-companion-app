import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GoodsBlueprintListComponent } from './goods-blueprint-list.component';

describe('GoodsBlueprintListComponent', () => {
  let component: GoodsBlueprintListComponent;
  let fixture: ComponentFixture<GoodsBlueprintListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GoodsBlueprintListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GoodsBlueprintListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
