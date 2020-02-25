import {WeaponTypeModel} from './weapon-type.model';

export interface WeaponFamilyModel {
  id: string;
  name: string;
  weaponType: WeaponTypeModel;
}
