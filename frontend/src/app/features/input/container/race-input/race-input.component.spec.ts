import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RaceInputComponent } from './race-input.component';

describe('RaceInputComponent', () => {
  let component: RaceInputComponent;
  let fixture: ComponentFixture<RaceInputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RaceInputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RaceInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
