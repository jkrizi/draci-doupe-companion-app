import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {EnumsService} from '../../../services/enums.service';
import {GoodsBlueprintService} from '../../../services/goods-blueprint.service';
import {GoodsBlueprintModel} from '../../../models/goods-blueprint.model';
import {v4 as uuid} from 'uuid';

@Component({
  selector: 'app-goods-blueprint-form',
  templateUrl: './goods-blueprint-form.component.html',
  styleUrls: ['./goods-blueprint-form.component.css']
})
export class GoodsBlueprintFormComponent implements OnInit {
  editMode = false;
  selectedGoodsBlueprint: GoodsBlueprintModel;

  // Backend enum
  itemTypes;

  goodsBlueprintForm: FormGroup;

  constructor(private enumsService: EnumsService, private goodsBlueprintService: GoodsBlueprintService) {
    this.itemTypes = [];
  }

  ngOnInit() {
    this.goodsBlueprintForm = new FormGroup(
      {
        id: new FormControl(null),
        name: new FormControl(null),
        publicDescription: new FormControl(null),
        privateDescription: new FormControl(null),
        weight: new FormControl(null),
        itemType: new FormControl(null)
      }
    );

    this.enumsService.getItemTypes().subscribe( itemTypes => this.itemTypes = itemTypes);

    this.goodsBlueprintService.selectedGoodsBlueprint.subscribe( selectedGoodsBlueprint => this.fillForm(selectedGoodsBlueprint));
  }

  onSubmit() {
    this.save();
  }

  save() {
    this.goodsBlueprintForm.patchValue({id: uuid()});
    this.goodsBlueprintService.save(this.goodsBlueprintForm.value);
    console.log(this.goodsBlueprintForm.value);
    this.clearForm();
  }

  update() {
    this.goodsBlueprintService.update(this.goodsBlueprintForm.value);
    this.clearForm();
  }

  restore() {
    this.fillForm(this.selectedGoodsBlueprint);
  }

  delete() {
    this.goodsBlueprintService.delete(this.selectedGoodsBlueprint.id);
    this.clearForm();
  }

  fillForm(selectedGoodsBlueprint: GoodsBlueprintModel) {
    this.clearForm();
    this.editMode = true;
    this.selectedGoodsBlueprint = selectedGoodsBlueprint;
    this.goodsBlueprintForm.patchValue(selectedGoodsBlueprint);
  }

  clearForm() {
    this.editMode = false;
    this.selectedGoodsBlueprint = null;
    this.goodsBlueprintForm.reset();
  }
}
