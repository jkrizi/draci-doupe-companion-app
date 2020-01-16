import { Component, OnInit } from '@angular/core';
import {WeaponBlueprintModel} from '../../models/weapon-blueprint.model';
import {WeaponBlueprintService} from '../../services/weapon-blueprint.service';

@Component({
  selector: 'app-weapon-blueprint-list',
  templateUrl: './weapon-blueprint-list.component.html',
  styleUrls: ['./weapon-blueprint-list.component.css']
})
export class WeaponBlueprintListComponent implements OnInit {
  weaponBlueprints: WeaponBlueprintModel[];

  constructor(private weaponBlueprintService: WeaponBlueprintService) { }

  ngOnInit() {
    this.weaponBlueprintService.getAll();
    this.weaponBlueprintService.weaponBlueprintList.subscribe( weaponBlueprints => {
      this.weaponBlueprints = weaponBlueprints;
    });
  }

  selectWeaponBlueprint(index: number) {
    this.weaponBlueprintService.select(this.weaponBlueprints[index]);
  }
}
