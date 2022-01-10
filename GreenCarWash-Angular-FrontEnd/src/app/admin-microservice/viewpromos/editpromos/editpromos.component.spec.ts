import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditpromosComponent } from './editpromos.component';

describe('EditpromosComponent', () => {
  let component: EditpromosComponent;
  let fixture: ComponentFixture<EditpromosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditpromosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditpromosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
