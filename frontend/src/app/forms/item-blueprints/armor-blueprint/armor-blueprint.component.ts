import {Component, OnInit} from '@angular/core';
import {FormArray, FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-armor-blueprint',
  templateUrl: './armor-blueprint.component.html',
  styleUrls: ['./armor-blueprint.component.css']
})
export class ArmorBlueprintComponent implements OnInit {
  editMode = false;

  // Backend enums
  bodySections = [];

  armorBlueprintForm: FormGroup;

  constructor() {
  }

  ngOnInit() {
    this.armorBlueprintForm = new FormGroup(
      {
        name: new FormControl(null),
        publicDescription: new FormControl(null),
        privateDescription: new FormControl(null),
        weight: new FormControl(null),
        defense: new FormControl(null),
        bodyCoverage: new FormArray([])
      }
    );
  }

  onSubmit() {
  }
}
