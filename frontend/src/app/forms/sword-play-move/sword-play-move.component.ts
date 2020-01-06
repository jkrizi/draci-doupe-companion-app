import { Component, OnInit } from '@angular/core';
import {FormArray, FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-sword-play-move',
  templateUrl: './sword-play-move.component.html',
  styleUrls: ['./sword-play-move.component.css']
})
export class SwordPlayMoveComponent implements OnInit {
  editMode: false;

  swordMoveForm: FormGroup;

  // Backend enums
  userWeaponTypes: any;
  opponentWeaponTypes: any;

  constructor() { }

  ngOnInit() {
    this.swordMoveForm = new FormGroup(
      {
        name: new FormControl(null),
        initiative: new FormControl(null),
        actions: new FormControl(null),
        description: new FormControl(null),
        humanoidOpponent: new FormControl(null),
        userWeapon: new FormArray([]),
        opponentWeapon: new FormArray([])
      }
    );
  }

  onSubmit() {

  }
}
