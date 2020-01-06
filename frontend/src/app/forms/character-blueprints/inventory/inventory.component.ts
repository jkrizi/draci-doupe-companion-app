import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  @Input() parentForm: FormGroup;

  // Local inventory holders
  weaponry = [];
  armory = [];
  treasury = [];
  goods = [];

  // Backend blueprints lists
  weaponBlueprint = [];
  armorBlueprint = [];
  treasureBlueprint = [];
  goodBlueprint = [];

  constructor() { }

  ngOnInit() {
  }

}
