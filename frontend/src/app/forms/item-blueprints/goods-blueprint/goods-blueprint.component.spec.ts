import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GoodsBlueprintComponent } from './goods-blueprint.component';

describe('GoodsBlueprintComponent', () => {
  let component: GoodsBlueprintComponent;
  let fixture: ComponentFixture<GoodsBlueprintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GoodsBlueprintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GoodsBlueprintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
