import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-form-controls',
  templateUrl: './form-controls.component.html',
  styleUrls: ['./form-controls.component.css']
})
export class FormControlsComponent implements OnInit {
  @Input() editMode;
  @Output() update = new EventEmitter();
  @Output() delete = new EventEmitter();
  @Output() cancel = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  onSave() {
    this.update.emit();
  }

  onDelete() {
    this.delete.emit();
  }

  onCancel() {
    this.cancel.emit();
  }
}
