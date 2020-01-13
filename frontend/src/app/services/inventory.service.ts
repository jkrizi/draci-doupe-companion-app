import { Injectable } from '@angular/core';
import {InventoryModel} from '../models/inventory.model';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  selectedInventory = new Subject<InventoryModel>();

  constructor() { }

  fillInventoryForm(inventory: InventoryModel) {
    this.selectedInventory.next(inventory);
  }
}
