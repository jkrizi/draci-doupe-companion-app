import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-spell',
  templateUrl: './spell.component.html',
  styleUrls: ['./spell.component.css']
})
export class SpellComponent implements OnInit {
  editMode = false;

  spellForm: FormGroup;

  constructor() { }

  ngOnInit() {
    this.spellForm = new FormGroup(
      {
        name: new FormControl(null),
        description: new FormControl(null),
        manna: new FormControl(null),
        range: new FormControl(null),
        conjuring: new FormControl(null),
        duration: new FormControl(null)
      }
    );
  }

  onSubmit() {

  }
}
