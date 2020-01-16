import { Injectable } from '@angular/core';
import {SwordMoveModel} from '../models/sword-move.model';
import {Subject} from 'rxjs';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SwordMoveService {
  selectedSwordMove = new Subject<SwordMoveModel>();
  swordMoveList = new Subject<SwordMoveModel[]>();

  constructor(private http: HttpClient) { }

  select(swordMoveModel: SwordMoveModel) {
    this.selectedSwordMove.next(swordMoveModel);
  }

  getAll() {
    this.http.get<SwordMoveModel[]>('http://localhost:8080/getAllSwordMoves.json').subscribe( swordMoves => this.swordMoveList.next(swordMoves));
  }

  save(newSwordMove: SwordMoveModel) {
    console.log(newSwordMove);
    this.http.post('http://localhost:8080/saveSwordMove.json', newSwordMove).subscribe(() => this.getAll());
  }

  update(existingSwordMove: SwordMoveModel) {
    this.http.post('http://localhost:8080/updateSwordMove.json', existingSwordMove).subscribe(() => this.getAll());
  }

  delete(id: string) {
    this.http.delete('http://localhost:8080/deleteSwordMove.json', {params: new HttpParams().set('id', id)}).subscribe(() => this.getAll());
  }
}
