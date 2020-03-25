import {Component, Input, OnInit} from '@angular/core';
import {AbstractControl, FormArray, FormControl, FormGroup} from '@angular/forms';
import {InventoryService} from '../../../services/inventory.service';
import {WeaponBlueprintModel} from '../../../models/weapon-blueprint.model';
import {ArmorBlueprintModel} from '../../../models/armor-blueprint.model';
import {GoodsBlueprintModel} from '../../../models/goods-blueprint.model';
import {TreasureBlueprintModel} from '../../../models/treasure-blueprint.model';

@Component({
  selector: 'app-inventory',
  templateUrl: './blueprint-inventory-form.component.html',
  styleUrls: ['./blueprint-inventory-form.component.css']
})
export class InventoryComponent implements OnInit {
  @Input() parentForm: FormGroup;

  // Backend blueprints lists
  weaponBlueprints: WeaponBlueprintModel[];
  armorBlueprints: ArmorBlueprintModel[];
  treasureBlueprints: TreasureBlueprintModel[];
  goodBlueprints: GoodsBlueprintModel[];

  constructor(private inventoryService: InventoryService) {}

  ngOnInit() {
    this.inventoryService.getAllItemBlueprints();
    this.inventoryService.weaponBlueprintList.subscribe((weaponBlueprints: WeaponBlueprintModel[]) => this.weaponBlueprints = weaponBlueprints);
    this.inventoryService.armorBlueprintList.subscribe((armorBlueprints: ArmorBlueprintModel[]) => this.armorBlueprints = armorBlueprints);
    this.inventoryService.treasureBlueprintList.subscribe((treasureBlueprints: TreasureBlueprintModel[]) => this.treasureBlueprints = treasureBlueprints);
    this.inventoryService.goodBlueprintList.subscribe((goodsBlueprints: GoodsBlueprintModel[]) => this.goodBlueprints = goodsBlueprints);
  }

  addItemToFormArray(formArray: FormArray, item: any) {
    formArray.push(new FormControl(item));
  }

  removeItemFromFormArray(formArray: FormArray, item: any) {
    const itemIndex = formArray.controls.findIndex((control: FormControl) => control.value.id === item.id);
    formArray.removeAt(itemIndex);
  }

  getFormArray(arrayName: string, parentForm: AbstractControl): FormArray {
    return (parentForm.get(arrayName) as FormArray);
  }
}
