import {EquipmentModel} from './equipment.model';

export interface StorageUnitModel {
  id: string;
  name: string;
  description: string;
  weight: string;
  storage: string;
  itemType: string;
  blueprintId: string;
  capacity: number;
  contentWeight: number;
  defaultStorage: boolean;
  equipment: EquipmentModel[];
  freeSpace: number;
}
