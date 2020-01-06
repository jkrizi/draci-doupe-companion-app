import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-goods-blueprint',
  templateUrl: './goods-blueprint.component.html',
  styleUrls: ['./goods-blueprint.component.css']
})
export class GoodsBlueprintComponent implements OnInit {
  editMode = false;

  // Backend enum
  goodsTypes = [];

  goodsBlueprintForm: FormGroup;

  constructor() { }

  ngOnInit() {
    this.goodsBlueprintForm = new FormGroup(
      {
        name: new FormControl(null),
        publicDescription: new FormControl(null),
        privateDescription: new FormControl(null),
        weight: new FormControl(null),
        goodsType: new FormControl(null)
      }
    );
  }

  onSubmit() {

  }
}
