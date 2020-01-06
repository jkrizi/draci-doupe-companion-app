import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SwordPlayMoveComponent } from './sword-play-move.component';

describe('SwordPlayMoveComponent', () => {
  let component: SwordPlayMoveComponent;
  let fixture: ComponentFixture<SwordPlayMoveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SwordPlayMoveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SwordPlayMoveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
