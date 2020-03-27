import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GoodsBlueprintInputComponent } from './goods-blueprint-input.component';

describe('GoodsBlueprintInputComponent', () => {
  let component: GoodsBlueprintInputComponent;
  let fixture: ComponentFixture<GoodsBlueprintInputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GoodsBlueprintInputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GoodsBlueprintInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
