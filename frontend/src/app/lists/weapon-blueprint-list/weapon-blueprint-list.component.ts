import {Component, OnDestroy, OnInit} from '@angular/core';
import {WeaponBlueprintModel} from '../../models/weapon-blueprint.model';
import {WeaponBlueprintService} from '../../services/weapon-blueprint.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-weapon-blueprint-list',
  templateUrl: './weapon-blueprint-list.component.html',
  styleUrls: ['./weapon-blueprint-list.component.css']
})
export class WeaponBlueprintListComponent implements OnInit, OnDestroy {
  private listSub: Subscription;

  weaponBlueprints: WeaponBlueprintModel[];

  constructor(private weaponBlueprintService: WeaponBlueprintService) { }

  ngOnInit() {
    this.weaponBlueprintService.getAll();
    this.weaponBlueprintService.weaponBlueprintList.subscribe( weaponBlueprints => this.weaponBlueprints = weaponBlueprints);
  }

  ngOnDestroy(): void {
    this.listSub.unsubscribe();
  }

  selectWeaponBlueprint(index: number) {
    this.weaponBlueprintService.select(this.weaponBlueprints[index]);
  }
}
