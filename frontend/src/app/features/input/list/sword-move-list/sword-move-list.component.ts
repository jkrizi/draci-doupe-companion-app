import {Component, OnDestroy, OnInit} from '@angular/core';
import {SwordMoveModel} from '../../../../models/sword-move.model';
import {SwordMoveService} from '../../../../services/sword-move.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-sword-move-list',
  templateUrl: './sword-move-list.component.html',
  styleUrls: ['./sword-move-list.component.css']
})
export class SwordMoveListComponent implements OnInit, OnDestroy {
  private listSub: Subscription;

  swordMoveList: SwordMoveModel[];

  constructor(private swordMoveService: SwordMoveService) { }

  ngOnInit() {
    this.swordMoveService.getAll();
    this.listSub = this.swordMoveService.swordMoveList.subscribe( swordMoves => this.swordMoveList = swordMoves);
  }

  ngOnDestroy(): void {
    this.listSub.unsubscribe();
  }

  selectSpell(index: number) {
    this.swordMoveService.select(this.swordMoveList[index]);
  }
}
