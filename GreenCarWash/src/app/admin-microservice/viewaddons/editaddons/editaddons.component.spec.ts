import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditaddonsComponent } from './editaddons.component';

describe('EditaddonsComponent', () => {
  let component: EditaddonsComponent;
  let fixture: ComponentFixture<EditaddonsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditaddonsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditaddonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
