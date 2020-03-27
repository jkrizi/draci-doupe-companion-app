import {Component, OnDestroy, OnInit} from '@angular/core';
import {ArmorBlueprintModel} from '../../models/armor-blueprint.model';
import {ArmorBlueprintService} from '../../services/armor-blueprint.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-armor-blueprint-list',
  templateUrl: './armor-blueprint-list.component.html',
  styleUrls: ['./armor-blueprint-list.component.css']
})
export class ArmorBlueprintListComponent implements OnInit, OnDestroy {
  private listSub: Subscription;

  armorBlueprints: ArmorBlueprintModel[];

  constructor(private armorBlueprintService: ArmorBlueprintService) { }

  ngOnInit() {
    this.armorBlueprintService.getAll();
    this.armorBlueprintService.armorBlueprintList.subscribe( armorBlueprints => this.armorBlueprints = armorBlueprints);
  }

  ngOnDestroy(): void {
    this.listSub.unsubscribe();
  }

  selectArmorBlueprint(index: number) {
    this.armorBlueprintService.select(this.armorBlueprints[index]);
  }
}
