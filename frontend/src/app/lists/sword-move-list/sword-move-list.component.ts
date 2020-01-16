import { Component, OnInit } from '@angular/core';
import {SwordMoveModel} from '../../models/sword-move.model';
import {SwordMoveService} from '../../services/sword-move.service';

@Component({
  selector: 'app-sword-move-list',
  templateUrl: './sword-move-list.component.html',
  styleUrls: ['./sword-move-list.component.css']
})
export class SwordMoveListComponent implements OnInit {
  swordMoveList: SwordMoveModel[];

  constructor(private swordMoveService: SwordMoveService) { }

  ngOnInit() {
    this.swordMoveService.getAll();
    this.swordMoveService.swordMoveList.subscribe( swordMoves => this.swordMoveList = swordMoves);
  }

  selectSpell(index: number) {
    this.swordMoveService.select(this.swordMoveList[index]);
  }
}
