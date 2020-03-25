export interface RaceModel {
  id: string;
  name: string;
  description: string;
  minWeight: number;
  maxWeight: number;
  minHeight: number;
  maxHeight: number;
  size: string;
  weaponFamilyId: string;
  strengthThrows: number;
  dexterityThrows: number;
  resistanceThrows: number;
  intelligenceThrows: number;
  charismaThrows: number;
  strengthBase: number;
  dexterityBase: number;
  resistanceBase: number;
  intelligenceBase: number;
  charismaBase: number;
  strengthCorrection: number;
  dexterityCorrection: number;
  resistanceCorrection: number;
  intelligenceCorrection: number;
  charismaCorrection: number;
}
