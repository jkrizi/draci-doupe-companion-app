import { Injectable } from '@angular/core';
import {ArmorBlueprintModel} from '../models/armor-blueprint.model';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArmorBlueprintService {
  armorBlueprintList = new Subject<ArmorBlueprintModel[]>();
  selectedArmorBlueprint = new Subject<ArmorBlueprintModel>();

  constructor(private http: HttpClient) { }

  select(selectedArmorBlueprint: ArmorBlueprintModel) {
    this.selectedArmorBlueprint.next(selectedArmorBlueprint);
  }

  getAll() {
    this.http.get<ArmorBlueprintModel[]>('http://localhost:8080/getAllArmorBlueprints.json').subscribe( armorBlueprints => this.armorBlueprintList.next(armorBlueprints));
  }

  save(newArmorBlueprint: ArmorBlueprintModel) {
    this.http.post('http://localhost:8080/saveArmorBlueprint.json', newArmorBlueprint).subscribe(() => this.getAll());
  }

  update(existingArmorBlueprint: ArmorBlueprintModel) {
    this.http.post('http://localhost:8080/updateArmorBlueprint.json', existingArmorBlueprint).subscribe(() => this.getAll());
  }

  delete(id: string) {
    this.http.delete('http://localhost:8080/deleteArmorBlueprint.json', {params: new HttpParams().set('id', id)}).subscribe(() => this.getAll());
  }
}
