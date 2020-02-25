import {Injectable} from '@angular/core';
import {GemstoneBlueprintModel} from '../models/gemstone-blueprint.model';
import {HttpClient} from '@angular/common/http';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GemstoneBlueprintService {
  public gemstoneBlueprintsList = new Subject<GemstoneBlueprintModel[]>();

  constructor(private http: HttpClient) { }

  getAll() {
    this.http.get<GemstoneBlueprintModel[]>('http://localhost:8080/getAllGemstoneBlueprints.json').subscribe(gemstoneBlueprints => this.gemstoneBlueprintsList.next(gemstoneBlueprints));
  }

  save(newGemstoneBlueprint: GemstoneBlueprintModel) {
    this.http.post('http://localhost:8080/saveGemstoneBlueprint.json', newGemstoneBlueprint).subscribe(() => this.getAll());
  }
}
