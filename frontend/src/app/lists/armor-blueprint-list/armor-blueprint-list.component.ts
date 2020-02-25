import { Component, OnInit } from '@angular/core';
import {ArmorBlueprintModel} from '../../models/armor-blueprint.model';
import {ArmorBlueprintService} from '../../services/armor-blueprint.service';

@Component({
  selector: 'app-armor-blueprint-list',
  templateUrl: './armor-blueprint-list.component.html',
  styleUrls: ['./armor-blueprint-list.component.css']
})
export class ArmorBlueprintListComponent implements OnInit {
  armorBlueprints: ArmorBlueprintModel[];

  constructor(private armorBlueprintService: ArmorBlueprintService) { }

  ngOnInit() {
    this.armorBlueprintService.getAll();
    this.armorBlueprintService.armorBlueprintList.subscribe( armorBlueprints => this.armorBlueprints = armorBlueprints);
  }

  selectArmorBlueprint(index: number) {
    this.armorBlueprintService.select(this.armorBlueprints[index]);
  }
}
