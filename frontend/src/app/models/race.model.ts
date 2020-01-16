import {WeaponBlueprintModel} from './weapon-blueprint.model';

export interface RaceModel {
  id: string;
  name: string;
  description: string;
  minWeight: number;
  maxWeight: number;
  minHeight: number;
  maxHeight: number;
  size: string;
  weapon: WeaponBlueprintModel;
  strengthNrOfThrows: number;
  dexterityNrOfThrows: number;
  resistanceNrOfThrows: number;
  intelligenceNrOfThrows: number;
  charismaNrOfThrows: number;
  strengthAbilityBase: number;
  dexterityAbilityBase: number;
  resistanceAbilityBase: number;
  intelligenceAbilityBase: number;
  charismaAbilityBase: number;
  strengthAbilityCorrection: number;
  dexterityAbilityCorrection: number;
  resistanceAbilityCorrection: number;
  intelligenceAbilityCorrection: number;
  charismaAbilityCorrection: number
}
