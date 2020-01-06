import {Component, OnInit} from '@angular/core';
import {FormArray, FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-person-blueprint',
  templateUrl: './person-blueprint.component.html',
  styleUrls: ['./person-blueprint.component.css']
})
export class PersonBlueprintComponent implements OnInit {
  editMode = false;

  // Backend blueprint list
  races = [];
  // Backend enum
  professions = [];

  personBlueprintForm: FormGroup;

  constructor() { }

  ngOnInit() {
    this.personBlueprintForm = new FormGroup(
      {
        name: new FormControl(null),
        description: new FormControl(null),
        level: new FormControl(null),
        profession: new FormControl(null),
        race: new FormControl(null),
        weaponry: new FormArray([]),
        armory: new FormArray([]),
        treasury: new FormArray([]),
        goods: new FormArray([]),
        goldCoin: new FormControl(null),
        silverCoin: new FormControl(null),
        bronzeCoin: new FormControl(null)
      }
    );
  }

  onSubmit() {

  }
}
