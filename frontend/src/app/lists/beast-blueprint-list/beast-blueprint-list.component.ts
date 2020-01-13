import { Component, OnInit } from '@angular/core';
import {BeastBlueprintService} from '../../services/beast-blueprint.service';
import {BeastBlueprintModel} from '../../models/beast-blueprint.model';

@Component({
  selector: 'app-beast-blueprint-list',
  templateUrl: './beast-blueprint-list.component.html',
  styleUrls: ['./beast-blueprint-list.component.css']
})
export class BeastBlueprintListComponent implements OnInit {

  beastBlueprints: BeastBlueprintModel[] = [];

  constructor(private beastBlueprintService: BeastBlueprintService) { }

  ngOnInit() {
    this.beastBlueprintService.getAll()
      .subscribe(pipedData => {
        this.beastBlueprints = pipedData;
      }
    );
  }

  passBlueprint(index: number) {
    this.beastBlueprintService.passBlueprint(this.beastBlueprints[index]);
  }
}
