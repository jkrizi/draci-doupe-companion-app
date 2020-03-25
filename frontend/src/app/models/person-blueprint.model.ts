import {RaceModel} from './race.model';
import {WeaponBlueprintModel} from './weapon-blueprint.model';
import {ArmorBlueprintModel} from './armor-blueprint.model';
import {TreasureBlueprintModel} from './treasure-blueprint.model';
import {GoodsBlueprintModel} from './goods-blueprint.model';

export interface PersonBlueprintModel {
  id: string;
  name: string;
  description: string;
  level: number;
  race: RaceModel;
  profession: string;
  weaponry: WeaponBlueprintModel[];
  armory: ArmorBlueprintModel[];
  treasury: TreasureBlueprintModel[];
  goods: GoodsBlueprintModel[];
  gold: number;
  silver: number;
  copper: number;
}
