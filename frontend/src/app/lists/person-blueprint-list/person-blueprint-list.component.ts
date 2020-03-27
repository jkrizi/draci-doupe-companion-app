import {Component, OnDestroy, OnInit} from '@angular/core';
import {PersonBlueprintModel} from '../../models/person-blueprint.model';
import {PersonBlueprintService} from '../../services/person-blueprint.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-person-blueprint-list',
  templateUrl: './person-blueprint-list.component.html',
  styleUrls: ['./person-blueprint-list.component.css']
})
export class PersonBlueprintListComponent implements OnInit, OnDestroy {
  private listSub: Subscription;

  personBlueprints: PersonBlueprintModel[];

  constructor(private personBlueprintService: PersonBlueprintService) { }

  ngOnInit() {
    this.personBlueprintService.getAll();
    this.personBlueprintService.personBlueprintList.subscribe((personBlueprints: PersonBlueprintModel[]) => this.personBlueprints = personBlueprints);
  }

  ngOnDestroy(): void {
    this.listSub.unsubscribe();
  }

  selectPersonBlueprint(index: number) {
    this.personBlueprintService.select(this.personBlueprints[index]);
  }
}
