import {Component, OnInit} from '@angular/core';
import {FormArray, FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-weapon-blueprint',
  templateUrl: './weapon-blueprint.component.html',
  styleUrls: ['./weapon-blueprint.component.css']
})
export class WeaponBlueprintComponent implements OnInit {
  editMode = false;
  melee = true;

  weaponTypes = [];

  weaponBlueprintForm: FormGroup;

  constructor() { }

  ngOnInit() {
    this.weaponBlueprintForm = new FormGroup(
      {
        name: new FormControl(null),
        publicDescription: new FormControl(null),
        privateDescription: new FormControl(null),
        weight: new FormControl(null),
        melee: new FormControl(true),
        attack: new FormControl(null),
        hurt: new FormControl(null),
        defense: new FormControl(null),
        initiative: new FormControl(null),
        shortRange: new FormControl(null),
        midRange: new FormControl(null),
        longRange: new FormControl(null),
        minReach: new FormControl(null),
        maxReach: new FormControl(null),
        weaponType: new FormArray([])
      }
    );
  }

  onSubmit() {

  }
}
