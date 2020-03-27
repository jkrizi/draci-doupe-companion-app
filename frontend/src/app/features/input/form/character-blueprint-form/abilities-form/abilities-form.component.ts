import {Component, Input, OnInit} from '@angular/core';
import {FormArray, FormGroup} from '@angular/forms';
import {AbilityService} from '../../../../../services/ability.service';

@Component({
  selector: 'app-abilities-form',
  templateUrl: './abilities-form.component.html',
  styleUrls: ['./abilities-form.component.css']
})
export class AbilitiesComponent implements OnInit {

  @Input() parentForm: FormArray;

  constructor(private abilityService: AbilityService) {
  }

  ngOnInit() {

    this.parentForm.controls.forEach((abilityControl: FormGroup) => {
      this.abilityService.setAbilityValueTracking(abilityControl, 'abilityValue', 'abilityBonusValue');
    });
  }
}
