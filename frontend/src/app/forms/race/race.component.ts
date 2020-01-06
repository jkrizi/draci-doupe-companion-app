import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-race',
  templateUrl: './race.component.html',
  styleUrls: ['./race.component.css']
})
export class RaceComponent implements OnInit {
  editMode: false;

  raceForm: FormGroup;

  // Backend enums
  sizes = [];
  racialWeapons = [];

  constructor() { }

  ngOnInit() {
    this.raceForm = new FormGroup(
      {
        name: new FormControl(null),
        description: new FormControl(null),
        size: new FormControl(null),
        minWeight: new FormControl(null),
        maxWeight: new FormControl(null),
        minHeight: new FormControl(null),
        maxHeight: new FormControl(null),
        racialWeapon: new FormControl(null),
        strengthThrows: new FormControl(null),
        dexterityThrows: new FormControl(null),
        resistanceThrows: new FormControl(null),
        intelligenceThrows: new FormControl(null),
        charismaThrows: new FormControl(null),
        strengthBase: new FormControl(null),
        dexterityBase: new FormControl(null),
        resistanceBase: new FormControl(null),
        intelligenceBase: new FormControl(null),
        charismaBase: new FormControl(null),
        strengthCorrection: new FormControl(null),
        dexterityCorrection: new FormControl(null),
        resistanceCorrection: new FormControl(null),
        intelligenceCorrection: new FormControl(null),
        charismaCorrection: new FormControl(null)
      }
    );
  }

  onSubmit() {

  }
}
