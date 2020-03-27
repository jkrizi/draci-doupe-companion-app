import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SwordMoveListComponent } from './sword-move-list.component';

describe('SwordMoveListComponent', () => {
  let component: SwordMoveListComponent;
  let fixture: ComponentFixture<SwordMoveListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SwordMoveListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SwordMoveListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
