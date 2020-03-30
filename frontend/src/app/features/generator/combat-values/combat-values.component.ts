import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {CombatValuesService} from '../../../services/combat-values.service';
import {CombatValuesModel} from '../../../models/combat-values.model';

@Component({
  selector: 'app-combat-values',
  templateUrl: './combat-values.component.html',
  styleUrls: ['./combat-values.component.css']
})
export class CombatValuesComponent implements OnInit {

  @Input() parentForm: FormGroup;

  activeCombatValues: CombatValuesModel;

  constructor(private combatValuesService: CombatValuesService) {
    this.activeCombatValues = {initiativeBase: 0, attack: 0, hurt: 0, activeDefense: 0, passiveDefense: 0};
  }

  ngOnInit() {
    this.combatValuesService.selectedCombatValues.subscribe( combatValues => {
      this.activeCombatValues = combatValues;
    });
  }

}
