import {GemstoneModel} from './gemstone.model';

export interface TreasureBlueprintModel {
  id: string;
  name: string;
  publicDescription: string;
  privateDescription: string;
  gemstones: GemstoneModel[];
  material: string;
  materialWeight: string;
  productQuality: string;
  goldValue: number;
  silverValue: number;
  copperValue: number;
}
