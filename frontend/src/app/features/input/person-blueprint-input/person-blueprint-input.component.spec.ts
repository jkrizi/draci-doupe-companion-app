import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonBlueprintInputComponent } from './person-blueprint-input.component';

describe('PersonBlueprintInputComponent', () => {
  let component: PersonBlueprintInputComponent;
  let fixture: ComponentFixture<PersonBlueprintInputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonBlueprintInputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonBlueprintInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
