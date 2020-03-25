import {GemstoneModel} from './gemstone.model';

export interface TreasureBlueprintModel {
  id: string;
  name: string;
  publicDescription: string;
  privateDescription: string;
  weight: number;
  gemstones: GemstoneModel[];
  material: string;
  materialWeight: string;
  productQuality: string;
  goldCoins: number;
  silverCoins: number;
  copperCoins: number;
}
