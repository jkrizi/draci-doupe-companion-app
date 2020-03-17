import { Injectable } from '@angular/core';
import {Subject} from 'rxjs';
import {PersonBlueprintModel} from '../models/person-blueprint.model';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonBlueprintService {
  personBlueprintList = new Subject<PersonBlueprintModel[]>();
  selectedPersonBlueprint = new Subject<PersonBlueprintModel>();

  constructor(private http: HttpClient) { }

  select(personBlueprintModel: PersonBlueprintModel) {
    this.selectedPersonBlueprint.next(personBlueprintModel);
  }

  getAll() {
    this.http
      .get<PersonBlueprintModel[]>('http://localhost:8080/getAllPersonBlueprints.json')
      .subscribe((personBlueprints: PersonBlueprintModel[]) => this.personBlueprintList.next(personBlueprints));
  }

  save(newPersonBlueprint: PersonBlueprintModel) {
    this.http.post('http://localhost:8080/savePersonBlueprint.json', newPersonBlueprint).subscribe(() => this.getAll());
  }

  update(existingPersonBlueprint: PersonBlueprintModel) {
    this.http.post('http://localhost:8080/updatePersonBlueprint.json', existingPersonBlueprint).subscribe(() => this.getAll());
  }

  delete(id: string) {
    this.http.delete('http://localhost:8080/deletePersonBlueprint.json', {params: new HttpParams().set('id', id)}).subscribe(() => this.getAll());
  }
}
