export interface SwordMoveModel {
  id: string;
  name: string;
  description: string;
  initiative: number;
  actions: number;
  humanoidOpponent: boolean;
  userWeaponTypes: string[];
  opponentWeaponTypes: string[];
}
