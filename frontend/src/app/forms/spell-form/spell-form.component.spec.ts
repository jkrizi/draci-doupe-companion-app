import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpellFormComponent } from './spell.component';

describe('SpellComponent', () => {
  let component: SpellFormComponent;
  let fixture: ComponentFixture<SpellFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpellFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpellFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
