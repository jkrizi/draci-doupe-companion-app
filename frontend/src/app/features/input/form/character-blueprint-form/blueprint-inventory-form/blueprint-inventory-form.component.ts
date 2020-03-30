import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {AbstractControl, FormArray, FormControl, FormGroup} from '@angular/forms';
import {InventoryService} from '../../../../../services/inventory.service';
import {WeaponBlueprintModel} from '../../../../../models/weapon-blueprint.model';
import {ArmorBlueprintModel} from '../../../../../models/armor-blueprint.model';
import {GoodsBlueprintModel} from '../../../../../models/goods-blueprint.model';
import {TreasureBlueprintModel} from '../../../../../models/treasure-blueprint.model';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-inventory',
  templateUrl: './blueprint-inventory-form.component.html',
  styleUrls: ['./blueprint-inventory-form.component.css']
})
export class InventoryComponent implements OnInit, OnDestroy {
  private weaponSub: Subscription;
  private armorSub: Subscription;
  private goodsSub: Subscription;
  private treasureSub: Subscription;

  @Input() parentForm: FormGroup;

  // Backend blueprints lists
  weaponBlueprints: WeaponBlueprintModel[];
  armorBlueprints: ArmorBlueprintModel[];
  treasureBlueprints: TreasureBlueprintModel[];
  goodBlueprints: GoodsBlueprintModel[];

  constructor(private inventoryService: InventoryService) {}

  ngOnInit() {
    this.inventoryService.getAllItemBlueprints();
    this.weaponSub = this.inventoryService.weaponBlueprintList.subscribe((weaponBlueprints: WeaponBlueprintModel[]) => this.weaponBlueprints = weaponBlueprints);
    this.armorSub = this.inventoryService.armorBlueprintList.subscribe((armorBlueprints: ArmorBlueprintModel[]) => this.armorBlueprints = armorBlueprints);
    this.treasureSub = this.inventoryService.treasureBlueprintList.subscribe((treasureBlueprints: TreasureBlueprintModel[]) => this.treasureBlueprints = treasureBlueprints);
    this.goodsSub = this.inventoryService.goodBlueprintList.subscribe((goodsBlueprints: GoodsBlueprintModel[]) => this.goodBlueprints = goodsBlueprints);
  }

  ngOnDestroy(): void {
    this.weaponSub.unsubscribe();
    this.armorSub.unsubscribe();
    this.goodsSub.unsubscribe();
    this.treasureSub.unsubscribe();
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
