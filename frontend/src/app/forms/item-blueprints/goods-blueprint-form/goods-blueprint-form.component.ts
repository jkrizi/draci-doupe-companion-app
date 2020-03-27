import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {EnumsService} from '../../../services/enums.service';
import {GoodsBlueprintService} from '../../../services/goods-blueprint.service';
import {GoodsBlueprintModel} from '../../../models/goods-blueprint.model';
import {v4 as uuid} from 'uuid';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-goods-blueprint-form',
  templateUrl: './goods-blueprint-form.component.html',
  styleUrls: ['./goods-blueprint-form.component.css']
})
export class GoodsBlueprintFormComponent implements OnInit, OnDestroy {
  private itemSub: Subscription;
  private listSub: Subscription;

  editMode = false;

  itemTypes;

  goodsBlueprintForm: FormGroup;

  constructor(private enumsService: EnumsService, private goodsBlueprintService: GoodsBlueprintService) {}

  ngOnInit() {
    this.initForm();

    this.itemSub = this.enumsService.getItemTypes().subscribe( itemTypes => this.itemTypes = itemTypes);

    this.listSub = this.goodsBlueprintService.selectedGoodsBlueprint.subscribe( selectedGoodsBlueprint => this.fillForm(selectedGoodsBlueprint));
  }

  ngOnDestroy(): void {
    this.itemSub.unsubscribe();
    this.listSub.unsubscribe();
  }

  initForm() {
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
  }

  onSubmit() {}

  save() {
    this.goodsBlueprintForm.patchValue({id: uuid()});
    this.goodsBlueprintService.save(this.goodsBlueprintForm.value);
    this.clearForm();
  }

  update() {
    this.goodsBlueprintService.update(this.goodsBlueprintForm.value);
    this.clearForm();
  }

  delete() {
    this.goodsBlueprintService.delete(this.goodsBlueprintForm.get('id').value);
    this.clearForm();
  }

  fillForm(selectedGoodsBlueprint: GoodsBlueprintModel) {
    this.clearForm();
    this.editMode = true;
    this.goodsBlueprintForm.patchValue(selectedGoodsBlueprint);
  }

  clearForm() {
    this.editMode = false;
    this.goodsBlueprintForm.reset();
  }
}
