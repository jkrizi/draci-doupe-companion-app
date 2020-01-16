import { Injectable } from '@angular/core';
import {SpellModel} from '../models/spell.model';
import {Subject} from 'rxjs';
import {HttpClient, HttpParams} from '@angular/common/http';
import {switchMap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SpellService {
  selectedSpell = new Subject<SpellModel>();
  spellList = new Subject<SpellModel[]>();

  constructor(private http: HttpClient) { }

  select(spellModel: SpellModel) {
    this.selectedSpell.next(spellModel);
  }

  getAll() {
    this.http.get<SpellModel[]>('http://localhost:8080/getAllSpells.json').subscribe( spells => {
      this.spellList.next(spells);
    });
  }

  save(newSpell: SpellModel) {
    this.http.post('http://localhost:8080/saveSpell.json', newSpell).subscribe( () => this.getAll());
  }

  update(existingSpell: SpellModel) {
    this.http.post('http://localhost:8080/updateSpell.json', existingSpell).subscribe(() => this.getAll());
  }

  delete(id: string) {
    this.http.delete('http://localhost:8080/deleteSpell.json', {params: new HttpParams().set('id', id)}).subscribe(() => this.getAll());
  }
}
