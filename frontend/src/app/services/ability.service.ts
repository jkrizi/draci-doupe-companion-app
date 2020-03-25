import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormGroup} from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class AbilityService {
  abilities: string[] = ['STRENGTH', 'DEXTERITY', 'RESISTANCE', 'INTELLIGENCE', 'CHARISMA'];

  constructor(private http: HttpClient) {
  }

  getAbilityBonus(abilityValue: number) {
    return this.http.get<number>('http://localhost:8080/calcAbilityBonus.json?abilityValue=' + abilityValue);
  }

  setAbilityValueTracking(form: FormGroup, valueControl: string, bonusControl: string) {
    form.get(valueControl).valueChanges.subscribe(value => {
      if (value === '' || value === null) {
        form.get(bonusControl).setValue(0);
      } else {
        this.getAbilityBonus(value).subscribe(response => {
          form.get(bonusControl).setValue(response);
        });
      }
    });
  }
}
