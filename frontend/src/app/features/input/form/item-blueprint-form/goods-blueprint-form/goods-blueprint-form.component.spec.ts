import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GoodsBlueprintFormComponent } from './goods-blueprint.component';

describe('GoodsBlueprintComponent', () => {
  let component: GoodsBlueprintFormComponent;
  let fixture: ComponentFixture<GoodsBlueprintFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GoodsBlueprintFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GoodsBlueprintFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
