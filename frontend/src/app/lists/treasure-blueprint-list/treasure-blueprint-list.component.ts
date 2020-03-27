import {Component, OnDestroy, OnInit} from '@angular/core';
import {TreasureBlueprintModel} from '../../models/treasure-blueprint.model';
import {TreasureBlueprintService} from '../../services/treasure-blueprint.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-treasure-blueprint-list',
  templateUrl: './treasure-blueprint-list.component.html',
  styleUrls: ['./treasure-blueprint-list.component.css']
})
export class TreasureBlueprintListComponent implements OnInit, OnDestroy {
  private listSub: Subscription;

  treasureBlueprints: TreasureBlueprintModel[];

  // TODO: expand html with some narrowed down version of gemstonesForm

  constructor(private treasureBlueprintService: TreasureBlueprintService) { }

  ngOnInit() {
    this.treasureBlueprintService.getAll();
    this.treasureBlueprintService.treasureBlueprintsList.subscribe((treasureBlueprints: TreasureBlueprintModel[]) => {
      this.treasureBlueprints = treasureBlueprints;
    });
  }

  ngOnDestroy(): void {
    this.listSub.unsubscribe();
  }

  selectTreasureBlueprint(index: number) {
    this.treasureBlueprintService.select(this.treasureBlueprints[index]);
  }
}
