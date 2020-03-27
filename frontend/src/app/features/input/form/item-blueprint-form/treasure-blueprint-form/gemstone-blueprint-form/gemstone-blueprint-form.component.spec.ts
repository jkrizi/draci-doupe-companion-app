import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GemstoneBlueprintFormComponent } from './gemstone-blueprint-form.component';

describe('GemstoneBlueprintFormComponent', () => {
  let component: GemstoneBlueprintFormComponent;
  let fixture: ComponentFixture<GemstoneBlueprintFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GemstoneBlueprintFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GemstoneBlueprintFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
