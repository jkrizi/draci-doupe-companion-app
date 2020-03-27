import {Component, OnDestroy, OnInit} from '@angular/core';
import {RaceModel} from '../../../../models/race.model';
import {RaceService} from '../../../../services/race.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-race-list',
  templateUrl: './race-list.component.html',
  styleUrls: ['./race-list.component.css']
})
export class RaceListComponent implements OnInit, OnDestroy {
  private listSub: Subscription;

  raceList: RaceModel[];

  constructor(private raceService: RaceService) { }

  ngOnInit() {
    this.raceService.getAll();
    this.listSub = this.raceService.raceList.subscribe( races => this.raceList = races);
  }

  ngOnDestroy(): void {
    this.listSub.unsubscribe();
  }

  selectRace(index: number) {
    this.raceService.select(this.raceList[index]);
  }
}
