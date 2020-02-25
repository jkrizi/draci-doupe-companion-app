import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EnumsService {

  constructor(private http: HttpClient) {
  }

  getSizes() {
    return this.http.get<string[]>('http://localhost:8080/characterSizes.json');
  }

  getVulnerabilities() {
    return this.http.get<string[]>('http://localhost:8080/vulnerabilities.json');
  }

  getAbilities() {
    return this.http.get<string[]>('http://localhost:8080/abilities.json');
  }

  getDifficulties() {
    return this.http.get<string[]>('http://localhost:8080/difficulties.json');
  }

  getBodySections() {
    return this.http.get<string[]>('http://localhost:8080/bodySections.json');
  }

  getItemTypes() {
    return this.http.get<string[]>('http://localhost:8080/itemTypes.json');
  }

  getMaterials() {
    return this.http.get<string[]>('http://localhost:8080/materials.json');
  }

  getQualityLevels() {
    return this.http.get<string[]>('http://localhost:8080/qualityLevels.json');
  }

  getColors() {
    return this.http.get<string[]>('http://localhost:8080/colors.json');
  }

  getWeaponDamageTypes() {
    return this.http.get<string[]>('http://localhost:8080/weaponDamageTypes.json');
  }

  getWeightCategories() {
    return this.http.get<string[]>('http://localhost:8080/weightCategories.json');
  }
}
