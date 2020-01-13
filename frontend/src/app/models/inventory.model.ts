import {StorageUnitModel} from './storage-unit.model';

export interface InventoryModel {
  id: string;
  limitWeight: number;
  contentWeight: number;
  coinPouch: number;
  bankVault: number;
  storageUnits: StorageUnitModel[];
  freeSpace: number;
}
