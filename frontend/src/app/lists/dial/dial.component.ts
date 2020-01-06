import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';

@Component({
  selector: 'app-dial',
  templateUrl: './dial.component.html',
  styleUrls: ['./dial.component.css']
})
export class DialComponent implements OnInit {
  beastBlueprint = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get('http://localhost:8080/beastBlueprints.json').pipe(map(responseData => {
        const localArray = [];
        for (const blueprint in responseData) {
          if (responseData.hasOwnProperty(blueprint)) {
            localArray.push({...responseData[blueprint]});
          }
        }
        return localArray;
    })).subscribe(
      pipedData => {
        this.beastBlueprint = pipedData;
        console.log(this.beastBlueprint);
      }
    );
  }

}
