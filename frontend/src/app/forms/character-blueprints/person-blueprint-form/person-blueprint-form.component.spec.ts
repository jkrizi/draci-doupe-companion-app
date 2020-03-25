import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonBlueprintFormComponent } from './person-blueprint.component';

describe('PersonBlueprintComponent', () => {
  let component: PersonBlueprintFormComponent;
  let fixture: ComponentFixture<PersonBlueprintFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonBlueprintFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonBlueprintFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
