import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-combat-values',
  templateUrl: './combat-values.component.html',
  styleUrls: ['./combat-values.component.css']
})
export class CombatValuesComponent implements OnInit {

  @Input() parentForm: FormGroup;

  constructor() { }

  ngOnInit() {
  }

}
