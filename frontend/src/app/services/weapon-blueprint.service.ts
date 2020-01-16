import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {WeaponBlueprintModel} from '../models/weapon-blueprint.model';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WeaponBlueprintService {
  weaponBlueprintList = new Subject<WeaponBlueprintModel[]>();
  selectedWeaponBlueprint =  new Subject<WeaponBlueprintModel>();

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<WeaponBlueprintModel[]>('http://localhost:8080/getAllWeaponBlueprints.json').subscribe( weaponBlueprints => this.weaponBlueprintList.next(weaponBlueprints));
  }

  select(weaponBlueprint: WeaponBlueprintModel) {
    this.selectedWeaponBlueprint.next(weaponBlueprint);
  }

  save(newWeaponBlueprint: WeaponBlueprintModel) {
    console.log(newWeaponBlueprint);
    this.http.post('http://localhost:8080/saveWeaponBlueprint.json', newWeaponBlueprint).subscribe(() => this.getAll());
  }

  update(existingWeaponBlueprint: WeaponBlueprintModel) {
    console.log(existingWeaponBlueprint);
    this.http.post('http://localhost:8080/updateWeaponBlueprint.json', existingWeaponBlueprint).subscribe(() => this.getAll());
  }

  delete(id: string) {
    this.http.delete('http://localhost:8080/deleteWeaponBlueprint.json', {params: new HttpParams().set('id', id)}).subscribe(() => this.getAll());
  }
}
