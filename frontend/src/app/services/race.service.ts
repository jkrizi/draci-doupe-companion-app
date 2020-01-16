import { Injectable } from '@angular/core';
import {RaceModel} from '../models/race.model';
import {Subject} from 'rxjs';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RaceService {
  selectedRace = new Subject<RaceModel>();
  raceList =  new Subject<RaceModel[]>();

  constructor(private http: HttpClient) { }

  select(raceModel: RaceModel) {
    this.selectedRace.next(raceModel);
  }

  getAll() {
    this.http.get<RaceModel[]>('http://localhost:8080/getAllRaces.json').subscribe( races => this.raceList.next(races));
  }

  save(newRace: RaceModel) {
    this.http.post('http://localhost:8080/saveRace.json', newRace).subscribe(() => this.getAll());
  }

  update(existingRace: RaceModel) {
    this.http.post('http://localhost:8080/updateRace.json', existingRace).subscribe(() => this.getAll());
  }

  delete(id: string) {
    this.http.delete('http://localhost:8080/deleteRace.json', {params: new HttpParams().set('id', id)}).subscribe(() => this.getAll());
  }
}
