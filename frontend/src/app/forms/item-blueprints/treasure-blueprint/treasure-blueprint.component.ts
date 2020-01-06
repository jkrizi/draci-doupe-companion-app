import { Component, OnInit } from '@angular/core';
import {FormArray, FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-treasure-blueprint',
  templateUrl: './treasure-blueprint.component.html',
  styleUrls: ['./treasure-blueprint.component.css']
})
export class TreasureBlueprintComponent implements OnInit {
  editMode = false;
  treasureStones = [{
    name: 'Ruby',
    weight: 10,
    count: 2,
    polished: true
  }];

  // Backend enums
  materials = [];
  qualityScale = [];
  gemStones = [];

  treasureBlueprintForm: FormGroup;

  constructor() { }

  ngOnInit() {
    this.treasureBlueprintForm = new FormGroup(
      {
        name: new FormControl(null),
        publicDescription: new FormControl(null),
        privateDescription: new FormControl(null),
        weight: new FormControl(null),
        treasureStones: new FormArray( [new FormGroup(
          {
            stoneWeight: new FormControl(null),
            stoneCount: new FormControl(null),
            polished: new FormControl(true),
          }
        )]),
        material: new FormControl(null),
        materialWeight: new FormControl(null),
        quality: new FormControl(null),
        goldCoin: new FormControl(null),
        silverCoin: new FormControl(null),
        bronzeCoin: new FormControl(null)
      }
    );
  }

  onSubmit() {

  }
}
