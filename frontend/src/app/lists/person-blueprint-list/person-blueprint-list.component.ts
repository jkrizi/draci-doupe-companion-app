import { Component, OnInit } from '@angular/core';
import {PersonBlueprintModel} from '../../models/person-blueprint.model';
import {PersonBlueprintService} from '../../services/person-blueprint.service';

@Component({
  selector: 'app-person-blueprint-list',
  templateUrl: './person-blueprint-list.component.html',
  styleUrls: ['./person-blueprint-list.component.css']
})
export class PersonBlueprintListComponent implements OnInit {
  personBlueprints: PersonBlueprintModel[];

  constructor(private personBlueprintService: PersonBlueprintService) { }

  ngOnInit() {
    this.personBlueprintService.getAll();
    this.personBlueprintService.personBlueprintList.subscribe((personBlueprints: PersonBlueprintModel[]) => this.personBlueprints = personBlueprints);
  }

  selectPersonBlueprint(index: number) {
    this.personBlueprintService.select(this.personBlueprints[index]);
  }
}
