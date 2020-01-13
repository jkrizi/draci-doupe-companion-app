import {AbilityModel} from './ability.model';
import {InventoryModel} from './inventory.model';
import {CombatValuesModel} from './combat-values.model';

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
  inventory: InventoryModel;
  combatValues: CombatValuesModel;
  pugnacity: number;
  persistence: number;
  domestication: number;
  schooled: boolean;
}
