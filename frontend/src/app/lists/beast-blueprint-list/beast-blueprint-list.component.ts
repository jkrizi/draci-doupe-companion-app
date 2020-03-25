import { Component, OnInit } from '@angular/core';
import {BeastBlueprintService} from '../../services/beast-blueprint.service';
import {BeastBlueprintModel} from '../../models/beast-blueprint.model';
import {AbilityModel} from '../../models/ability.model';

@Component({
  selector: 'app-beast-blueprint-list',
  templateUrl: './beast-blueprint-list.component.html',
  styleUrls: ['./beast-blueprint-list.component.css']
})
export class BeastBlueprintListComponent implements OnInit {
  beastBlueprints: BeastBlueprintModel[];

  constructor(private beastBlueprintService: BeastBlueprintService) { }

  ngOnInit() {
    this.beastBlueprintService.getAll();
    this.beastBlueprintService.beastBlueprintList.subscribe((beastBlueprints: BeastBlueprintModel[]) => this.beastBlueprints = beastBlueprints);
  }

  selectBeastBlueprint(index: number) {
    this.beastBlueprintService.select(this.beastBlueprints[index]);
  }

  getAbility(abilityName: string, abilityArray: AbilityModel[]): AbilityModel {
    return abilityArray.find((abilityScore: AbilityModel) => abilityScore.ability === abilityName);
  }
}
