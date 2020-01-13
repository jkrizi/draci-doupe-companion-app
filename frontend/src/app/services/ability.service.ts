import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AbilityModel} from '../models/ability.model';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AbilityService {
  selectedAbilities = new Subject<AbilityModel[]>();

  constructor(private http: HttpClient) {
  }

  getAbilityBonus(abilityValue: number) {
    return this.http.get<number>('http://localhost:8080/calcAbilityBonus.json?abilityValue=' + abilityValue);
  }

  fillAbilityForm(abilityMap: AbilityModel[]) {
    this.selectedAbilities.next(abilityMap);
  }
}
