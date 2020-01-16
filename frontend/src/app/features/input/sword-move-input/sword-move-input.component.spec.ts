import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SwordMoveInputComponent } from './sword-move-input.component';

describe('SwordMoveInputComponent', () => {
  let component: SwordMoveInputComponent;
  let fixture: ComponentFixture<SwordMoveInputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SwordMoveInputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SwordMoveInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
