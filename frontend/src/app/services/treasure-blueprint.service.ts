import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {TreasureBlueprintModel} from '../models/treasure-blueprint.model';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TreasureBlueprintService {
  treasureBlueprintsList =  new Subject<TreasureBlueprintModel[]>();
  selectedTreasureBlueprint =  new Subject<TreasureBlueprintModel>();

  constructor(private http: HttpClient) {}

  select(selectedTreasureBlueprint: TreasureBlueprintModel) {
    this.selectedTreasureBlueprint.next(selectedTreasureBlueprint);
  }

  getAll() {
    this.http.get<TreasureBlueprintModel[]>('http://localhost:8080/getAllTreasureBlueprints.json').subscribe( treasureBlueprints => this.treasureBlueprintsList.next(treasureBlueprints));
  }

  save(newTreasureBlueprint: TreasureBlueprintModel) {
    this.http.post('http://localhost:8080/saveTreasureBlueprint.json', newTreasureBlueprint).subscribe(() => this.getAll());
  }

  update(existingTreasureBlueprint: TreasureBlueprintModel) {
    this.http.post('http://localhost:8080/updateTreasureBlueprint.json', existingTreasureBlueprint).subscribe(() => this.getAll());
  }

  delete(id: string) {
    this.http.delete('http://localhost:8080/deleteTreasure.json', {params: new HttpParams().set('id', id)}).subscribe(() => this.getAll());
  }
}
