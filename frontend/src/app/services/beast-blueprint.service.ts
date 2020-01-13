import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Subject} from 'rxjs';
import {BeastBlueprintModel} from '../models/beast-blueprint.model';

@Injectable({
  providedIn: 'root'
})
export class BeastBlueprintService {

  selectedBlueprint = new Subject<any>();

  constructor(private http: HttpClient, ) { }

  passBlueprint(beastBlueprint: BeastBlueprintModel) {
    this.selectedBlueprint.next(beastBlueprint);
  }

  getAll() {
    return this.http.get<BeastBlueprintModel[]>('http://localhost:8080/beastBlueprints.json')
      .pipe(
        map(responseData => {
          const localArray: BeastBlueprintModel[] = [];
          for (const response in responseData) {
            if (responseData.hasOwnProperty(response)) {
              localArray.push({...responseData[response]});
            }
          }
          return localArray;
        }));
  }
}
