import {Component, OnInit} from '@angular/core';
import {TreasureBlueprintModel} from '../../models/treasure-blueprint.model';

@Component({
  selector: 'app-treasure-blueprint-list',
  templateUrl: './treasure-blueprint-list.component.html',
  styleUrls: ['./treasure-blueprint-list.component.css']
})
export class TreasureBlueprintListComponent implements OnInit {
  treasureBlueprints: TreasureBlueprintModel[];

  constructor() { }

  ngOnInit() {
  }

  selectTreasureBlueprint(i: number) {

  }
}
