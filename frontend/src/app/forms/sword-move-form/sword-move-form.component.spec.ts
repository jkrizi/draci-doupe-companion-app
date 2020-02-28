import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SwordMoveFormComponent } from './sword-move-form.component';

describe('SwordPlayMoveComponent', () => {
  let component: SwordMoveFormComponent;
  let fixture: ComponentFixture<SwordMoveFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SwordMoveFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SwordMoveFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
