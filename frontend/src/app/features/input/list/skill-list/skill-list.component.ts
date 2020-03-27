import {Component, OnDestroy, OnInit} from '@angular/core';
import {SkillService} from '../../../../services/skill.service';
import {SkillModel} from '../../../../models/skill.model';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-skill-list',
  templateUrl: './skill-list.component.html',
  styleUrls: ['./skill-list.component.css']
})
export class SkillListComponent implements OnInit, OnDestroy {
  private listSub: Subscription;

  skillList: SkillModel[];

  constructor(private skillService: SkillService) { }

  ngOnInit() {
    this.skillService.getAll();
    this.listSub = this.skillService.skillList.subscribe( skillList => this.skillList = skillList);
  }

  ngOnDestroy(): void {
    this.listSub.unsubscribe();
  }

  selectSkill(index: number) {
    this.skillService.select(this.skillList[index]);
  }
}
