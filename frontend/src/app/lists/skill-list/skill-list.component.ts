import { Component, OnInit } from '@angular/core';
import {SkillService} from '../../services/skill.service';
import {SkillModel} from '../../models/skill.model';

@Component({
  selector: 'app-skill-list',
  templateUrl: './skill-list.component.html',
  styleUrls: ['./skill-list.component.css']
})
export class SkillListComponent implements OnInit {
  skillList: SkillModel[];

  constructor(private skillService: SkillService) { }

  ngOnInit() {
    this.skillService.getAll();
    this.skillService.skillList.subscribe( skillList => this.skillList = skillList);
  }

  selectSkill(index: number) {
    this.skillService.select(this.skillList[index]);
  }
}
