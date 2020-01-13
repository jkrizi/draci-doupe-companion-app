import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EnumsService {

  constructor(private http: HttpClient) { }

  getSizes() {
    return this.http.get<string[]>('http://localhost:8080/characterSizes.json');
  }

  getVulnerabilities() {
    return this.http.get<string[]>('http://localhost:8080/vulnerabilities.json');
  }

  getAbilities() {
    return this.http.get<string[]>('http://localhost:8080/abilities.json');
  }
}
