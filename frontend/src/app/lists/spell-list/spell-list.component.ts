import {Component, OnDestroy, OnInit} from '@angular/core';
import {SpellModel} from '../../models/spell.model';
import {SpellService} from '../../services/spell.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-spell-list',
  templateUrl: './spell-list.component.html',
  styleUrls: ['./spell-list.component.css']
})
export class SpellListComponent implements OnInit, OnDestroy {
  private listSub: Subscription;

  spellList: SpellModel[] = [];

  constructor(private spellService: SpellService) { }

  ngOnInit() {
    this.spellService.getAll();
    this.spellService.spellList.subscribe( spellList => this.spellList = spellList);
  }

  ngOnDestroy(): void {
    this.listSub.unsubscribe();
  }

  selectSpell(index: number) {
    this.spellService.select(this.spellList[index]);
  }
}
