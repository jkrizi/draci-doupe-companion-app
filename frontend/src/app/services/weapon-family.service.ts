import {Injectable} from '@angular/core';
import {WeaponFamilyModel} from '../models/weapon-family.model';
import {HttpClient} from '@angular/common/http';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WeaponFamilyService {
  public weaponFamilyList = new Subject<WeaponFamilyModel[]>();

  constructor(private http: HttpClient) { }

  getAll() {
    this.http.get<WeaponFamilyModel[]>('http://localhost:8080/getAllWeaponFamilies.json').subscribe((weaponFamilies: WeaponFamilyModel[]) => this.weaponFamilyList.next(weaponFamilies));
  }

  save(newWeaponFamily: WeaponFamilyModel) {
    this.http.post('http://localhost:8080/saveWeaponFamily.json', newWeaponFamily).subscribe(() => this.getAll());
  }
}
