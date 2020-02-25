import {Injectable} from '@angular/core';
import {GoodsBlueprintModel} from '../models/goods-blueprint.model';
import {Subject} from 'rxjs';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GoodsBlueprintService {
  goodsBlueprintList = new Subject<GoodsBlueprintModel[]>();
  selectedGoodsBlueprint =  new Subject<GoodsBlueprintModel>();

  constructor(private http: HttpClient) { }

  select(selectedGoodsBlueprint: GoodsBlueprintModel) {
    this.selectedGoodsBlueprint.next(selectedGoodsBlueprint);
  }

  getAll() {
    this.http.get<GoodsBlueprintModel[]>('http://localhost:8080/getAllGoodsBlueprints.json').subscribe( goodsBlueprints => this.goodsBlueprintList.next(goodsBlueprints));
  }

  save(newGoodsBlueprint: GoodsBlueprintModel) {
    this.http.post('http://localhost:8080/saveGoodsBlueprint.json', newGoodsBlueprint).subscribe(() => this.getAll());
  }

  update(existingGoodsBlueprint: GoodsBlueprintModel) {
    this.http.post('http://localhost:8080/updateGoodsBlueprint.json', existingGoodsBlueprint).subscribe(() => this.getAll());
  }

  delete(id: string) {
    this.http.delete('http://localhost:8080/deleteGoodsBlueprint.json', {params: new HttpParams().set('id', id)}).subscribe(() => this.getAll());
  }
}
