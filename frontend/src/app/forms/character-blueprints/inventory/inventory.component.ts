import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {InventoryService} from '../../../services/inventory.service';
import {InventoryModel} from '../../../models/inventory.model';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  @Input() parentForm: FormGroup;
  selectedInventory: InventoryModel;

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

  constructor(private inventoryService: InventoryService) { }

  ngOnInit() {
    this.inventoryService.selectedInventory.subscribe( inventory => {
      this.selectedInventory = inventory;
    });
  }

}
