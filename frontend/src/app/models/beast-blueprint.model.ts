import {AbilityModel} from './ability.model';
import {WeaponBlueprintModel} from './weapon-blueprint.model';
import {ArmorBlueprintModel} from './armor-blueprint.model';
import {TreasureBlueprintModel} from './treasure-blueprint.model';
import {GoodsBlueprintModel} from './goods-blueprint.model';

export interface BeastBlueprintModel {
  id: string;
  origin: string;
  name: string;
  species: string;
  description: string;
  viability: number;
  viabilityBonus: number;
  manna: number;
  mobility: number;
  abilityMap: AbilityModel[];
  sizes: string[];
  vulnerabilities: string[];
  initiative: number;
  pugnacity: number;
  persistence: number;
  domestication: number;
  schooled: boolean;
  weaponry: WeaponBlueprintModel[];
  armory: ArmorBlueprintModel[];
  treasury: TreasureBlueprintModel[];
  goods: GoodsBlueprintModel[];
  gold: number;
  silver: number;
  copper: number;
}
