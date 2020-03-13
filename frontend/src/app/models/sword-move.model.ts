import {WeaponFamilyModel} from './weapon-family.model';

export interface SwordMoveModel {
  id: string;
  name: string;
  description: string;
  initiative: number;
  actions: number;
  humanoidOpponent: boolean;
  allowedUserWeapons: WeaponFamilyModel[];
  allowedOpponentWeapons: WeaponFamilyModel[];
}
