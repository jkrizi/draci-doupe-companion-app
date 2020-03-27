import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonBlueprintListComponent } from './person-blueprint-list.component';

describe('PersonBlueprintListComponent', () => {
  let component: PersonBlueprintListComponent;
  let fixture: ComponentFixture<PersonBlueprintListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonBlueprintListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonBlueprintListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
