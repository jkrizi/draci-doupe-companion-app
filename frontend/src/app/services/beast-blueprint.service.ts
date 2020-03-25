import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Subject} from 'rxjs';
import {BeastBlueprintModel} from '../models/beast-blueprint.model';
import {PersonBlueprintModel} from '../models/person-blueprint.model';

@Injectable({
  providedIn: 'root'
})
export class BeastBlueprintService {
  beastBlueprintList = new Subject<BeastBlueprintModel[]>();
  selectedBeastBlueprint = new Subject<BeastBlueprintModel>();

  constructor(private http: HttpClient, ) { }

  select(beastBlueprint: BeastBlueprintModel) {
    this.selectedBeastBlueprint.next(beastBlueprint);
  }

  getAll() {
    this.http.get<BeastBlueprintModel[]>('http://localhost:8080/getAllBeastBlueprints.json').subscribe((beastBlueprints: BeastBlueprintModel[]) => this.beastBlueprintList.next(beastBlueprints));
  }

  save(newBeastBlueprint: BeastBlueprintModel) {
    this.http.post('http://localhost:8080/saveBeastBlueprint.json', newBeastBlueprint).subscribe(() => this.getAll());
  }

  update(existingBeastBlueprint: BeastBlueprintModel) {
    this.http.post('http://localhost:8080/updateBeastBlueprint.json', existingBeastBlueprint).subscribe(() => this.getAll());
  }

  delete(id: string) {
    this.http.delete('http://localhost:8080/deleteBeastBlueprint.json', {params: new HttpParams().set('id', id)}).subscribe(() => this.getAll());
  }

  sendMail() {
    this.http.get('http://localhost:8080/sendMail.json').subscribe();
  }
}
