import { Component, OnInit } from '@angular/core';
import {SpellModel} from '../../models/spell.model';
import {SpellService} from '../../services/spell.service';

@Component({
  selector: 'app-spell-list',
  templateUrl: './spell-list.component.html',
  styleUrls: ['./spell-list.component.css']
})
export class SpellListComponent implements OnInit {
  spellList: SpellModel[] = [];

  constructor(private spellService: SpellService) { }

  ngOnInit() {
    this.spellService.getAll();
    this.spellService.spellList.subscribe( spellList => this.spellList = spellList);
  }

  selectSpell(index: number) {
    this.spellService.select(this.spellList[index]);
  }
}
