import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {AbilityService} from '../../../services/ability.service';

@Component({
  selector: 'app-abilities',
  templateUrl: './abilities.component.html',
  styleUrls: ['./abilities.component.css']
})
export class AbilitiesComponent implements OnInit {

  @Input() parentForm: FormGroup;

  strengthBonus = 0;
  dexterityBonus = 0;
  resistanceBonus = 0;
  intelligenceBonus = 0;
  charismaBonus = 0;

  constructor(private abilityService: AbilityService) {
  }

  ngOnInit() {

    this.parentForm.get('abilityMap').get('strength').valueChanges.subscribe(
      (value => {
        if (value === '') {
          this.strengthBonus = 0;
        } else {
          this.abilityService.getAbilityBonus(value).subscribe(response => {
            this.strengthBonus = response;
          });
        }
      })
    );

    this.parentForm.get('abilityMap').get('dexterity').valueChanges.subscribe(
      (value => {
        if (value === '') {
          this.dexterityBonus = 0;
        } else {
          this.abilityService.getAbilityBonus(value).subscribe(response => {
            this.dexterityBonus = response;
          });
        }
      })
    );

    this.parentForm.get('abilityMap').get('resistance').valueChanges.subscribe(
      (value => {
        if (value === '') {
          this.resistanceBonus = 0;
        } else {
          this.abilityService.getAbilityBonus(value).subscribe(response => {
            this.resistanceBonus = response;
          });
        }
      })
    );

    this.parentForm.get('abilityMap').get('intelligence').valueChanges.subscribe(
      (value => {
        if (value === '') {
          this.intelligenceBonus = 0;
        } else {
          this.abilityService.getAbilityBonus(value).subscribe(response => {
            this.intelligenceBonus = response;
          });
        }
      })
    );

    this.parentForm.get('abilityMap').get('charisma').valueChanges.subscribe(
      (value => {
        if (value === '') {
          this.charismaBonus = 0;
        } else {
          this.abilityService.getAbilityBonus(value).subscribe(response => {
            this.charismaBonus = response;
          });
        }

      })
    );

    this.abilityService.selectedAbilities.subscribe(abilityMap => {
      this.parentForm.get('abilityMap').setValue({
        strength: abilityMap['STRENGTH'].abilityValue,
        dexterity: abilityMap['DEXTERITY'].abilityValue,
        resistance: abilityMap['RESISTANCE'].abilityValue,
        intelligence: abilityMap['INTELLIGENCE'].abilityValue,
        charisma: abilityMap['CHARISMA'].abilityValue
      });
    });
  }


}
