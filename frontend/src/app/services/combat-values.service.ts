import { Injectable } from '@angular/core';
import {CombatValuesModel} from '../models/combat-values.model';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CombatValuesService {
  selectedCombatValues = new Subject<CombatValuesModel>();

  constructor() { }

  fillCombatValues(combatValues: CombatValuesModel) {
    this.selectedCombatValues.next(combatValues);
  }
}
