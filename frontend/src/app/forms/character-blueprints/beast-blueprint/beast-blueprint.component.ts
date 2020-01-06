import {Component, Input, OnInit} from '@angular/core';
import {FormArray, FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-beast-blueprint',
  templateUrl: './beast-blueprint.component.html',
  styleUrls: ['./beast-blueprint.component.css']
})
export class BeastBlueprintComponent implements OnInit {
  editMode = false;

  beastBlueprintForm: FormGroup;

  constructor() {
  }

  ngOnInit() {
    this.beastBlueprintForm = new FormGroup(
      {
        name: new FormControl(null),
        description: new FormControl(null),
        origin: new FormControl(null),
        species: new FormControl(null),
        schooled: new FormControl(false),
        strength: new FormControl(null),
        dexterity: new FormControl(null),
        resistance: new FormControl(null),
        intelligence: new FormControl(null),
        charisma: new FormControl(null),
        viability: new FormControl(null),
        viabilityBonus: new FormControl(null),
        manna: new FormControl(null),
        mobility: new FormControl(null),
        persistence: new FormControl(null),
        pugnacity: new FormControl(null),
        domestication: new FormControl(null),
        initiativeBonus: new FormControl(null),
        sizes: new FormArray([
          new FormControl({name: 'A', status: false}),
          new FormControl({name: 'A0', status: false})
        ]),
        vulnerabilities: new FormArray([
          new FormControl({name: 'A', status: false}),
          new FormControl({name: 'B', status: false})
        ]),
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

  getVulnerabilities() {
    return (this.beastBlueprintForm.get('vulnerabilities') as FormArray).controls;
  }

  getSizes() {
    return (this.beastBlueprintForm.get('sizes') as FormArray).controls;
  }
}
