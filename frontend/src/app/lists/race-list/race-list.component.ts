import { Component, OnInit } from '@angular/core';
import {RaceModel} from '../../models/race.model';
import {RaceService} from '../../services/race.service';

@Component({
  selector: 'app-race-list',
  templateUrl: './race-list.component.html',
  styleUrls: ['./race-list.component.css']
})
export class RaceListComponent implements OnInit {
  raceList: RaceModel[];

  constructor(private raceService: RaceService) { }

  ngOnInit() {
    this.raceService.getAll();
    this.raceService.raceList.subscribe( races => this.raceList = races);
  }

  selectRace(index: number) {
    this.raceService.select(this.raceList[index]);
  }
}
