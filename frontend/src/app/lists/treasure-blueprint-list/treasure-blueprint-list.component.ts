import {Component, OnInit} from '@angular/core';
import {TreasureBlueprintModel} from '../../models/treasure-blueprint.model';
import {TreasureBlueprintService} from '../../services/treasure-blueprint.service';

@Component({
  selector: 'app-treasure-blueprint-list',
  templateUrl: './treasure-blueprint-list.component.html',
  styleUrls: ['./treasure-blueprint-list.component.css']
})
export class TreasureBlueprintListComponent implements OnInit {
  treasureBlueprints: TreasureBlueprintModel[];

  // TODO: expand html with some narrowed down version of gemstones

  constructor(private treasureBlueprintService: TreasureBlueprintService) { }

  ngOnInit() {
    this.treasureBlueprintService.getAll();
    this.treasureBlueprintService.treasureBlueprintsList.subscribe((treasureBlueprints: TreasureBlueprintModel[]) => {
      this.treasureBlueprints = treasureBlueprints;
    });
  }

  selectTreasureBlueprint(index: number) {
    this.treasureBlueprintService.select(this.treasureBlueprints[index]);
  }
}
