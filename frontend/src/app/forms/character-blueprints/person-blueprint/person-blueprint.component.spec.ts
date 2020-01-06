import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonBlueprintComponent } from './person-blueprint.component';

describe('PersonBlueprintComponent', () => {
  let component: PersonBlueprintComponent;
  let fixture: ComponentFixture<PersonBlueprintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonBlueprintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonBlueprintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
