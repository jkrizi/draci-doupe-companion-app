import {InventoryModel} from './inventory.model';
import {CombatValuesModel} from './combat-values.model';

export interface BeastModel {
  id: string;
  name: string;
  description: string;
  life: number;
  size: string;
  inventory: InventoryModel;
  combatValues: CombatValuesModel;
}
