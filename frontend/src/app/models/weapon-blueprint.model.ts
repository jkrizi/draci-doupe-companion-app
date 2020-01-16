export interface WeaponBlueprintModel {
  id: string;
  name: string;
  privateDescription: string;
  publicDescription: string;
  weight: number;
  attack: number;
  hurt: number;
  defense: number;
  initiativeModifier: number;
  shortRangeLimit: number;
  midRangeLimit: number;
  longRangeLimit: number;
  minReach: number;
  maxReach: number;
  weaponTypes: string[];
}
