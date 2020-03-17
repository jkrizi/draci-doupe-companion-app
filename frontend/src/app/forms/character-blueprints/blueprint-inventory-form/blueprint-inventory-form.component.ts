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
  weaponBlueprints = [];
  armorBlueprints = [];
  treasureBlueprints = [];
  goodBlueprints = [];

  constructor(
    private inventoryService: InventoryService
  ) {}

  ngOnInit() {
    this.inventoryService.getAllItemBlueprints();
    this.inventoryService.weaponBlueprintList.subscribe((weaponBlueprints: WeaponBlueprintModel[]) => this.weaponBlueprints = weaponBlueprints);
    this.inventoryService.armorBlueprintList.subscribe((armorBlueprints: ArmorBlueprintModel[]) => this.armorBlueprints = armorBlueprints);
    this.inventoryService.treasureBlueprintList.subscribe((treasureBlueprints: TreasureBlueprintModel[]) => this.treasureBlueprints = treasureBlueprints);
    this.inventoryService.goodBlueprintList.subscribe((goodsBlueprints: GoodsBlueprintModel[]) => this.goodBlueprints = goodsBlueprints);
  }

  addItemToForm(formArray: FormArray, item: any) {
    formArray.push(new FormControl(item));
  }

  removeItemFromForm(formArray: FormArray, item: any) {
    const itemIndex = formArray.controls.findIndex((control: FormControl) => control.value.id === item.id);
    formArray.removeAt(itemIndex);
  }

  getWeaponry(): FormArray {
    return (this.parentForm.get('weaponry') as FormArray);
  }

  getArmory(): FormArray {
    return (this.parentForm.get('armory') as FormArray);
  }

  getTreasury(): FormArray {
    return (this.parentForm.get('treasury') as FormArray);
  }

  getGoods(): FormArray {
    return (this.parentForm.get('goods') as FormArray);
  }
}
