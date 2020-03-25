import {Injectable} from '@angular/core';
import {WeaponBlueprintService} from './weapon-blueprint.service';
import {ArmorBlueprintService} from './armor-blueprint.service';
import {TreasureBlueprintService} from './treasure-blueprint.service';
import {GoodsBlueprintService} from './goods-blueprint.service';
import {WeaponBlueprintModel} from '../models/weapon-blueprint.model';
import {ArmorBlueprintModel} from '../models/armor-blueprint.model';
import {TreasureBlueprintModel} from '../models/treasure-blueprint.model';
import {GoodsBlueprintModel} from '../models/goods-blueprint.model';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {
  weaponBlueprintList = new Subject<WeaponBlueprintModel[]>();
  armorBlueprintList = new Subject<ArmorBlueprintModel[]>();
  treasureBlueprintList = new Subject<TreasureBlueprintModel[]>();
  goodBlueprintList = new Subject<GoodsBlueprintModel[]>();

  constructor(
    private weaponBlueprintService: WeaponBlueprintService,
    private armorBlueprintService: ArmorBlueprintService,
    private treasureBlueprintsService: TreasureBlueprintService,
    private goodsBlueprintService: GoodsBlueprintService
  ) { }

  getAllItemBlueprints() {
    this.weaponBlueprintService.getAll();
    this.armorBlueprintService.getAll();
    this.treasureBlueprintsService.getAll();
    this.goodsBlueprintService.getAll();
    this.weaponBlueprintService.weaponBlueprintList.subscribe((weaponBlueprints: WeaponBlueprintModel[]) => this.weaponBlueprintList.next(weaponBlueprints));
    this.armorBlueprintService.armorBlueprintList.subscribe((armorBlueprints: ArmorBlueprintModel[]) => this.armorBlueprintList.next(armorBlueprints));
    this.treasureBlueprintsService.treasureBlueprintsList.subscribe((treasureBlueprints: TreasureBlueprintModel[]) => this.treasureBlueprintList.next(treasureBlueprints));
    this.goodsBlueprintService.goodsBlueprintList.subscribe((goodsBlueprints: GoodsBlueprintModel[]) => this.goodBlueprintList.next(goodsBlueprints));
  }
}
