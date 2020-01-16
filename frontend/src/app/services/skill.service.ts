import { Injectable } from '@angular/core';
import {SkillModel} from '../models/skill.model';
import {Subject} from 'rxjs';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SkillService {
  selectedSkill = new Subject<SkillModel>();
  skillList =  new Subject<SkillModel[]>();

  constructor(private http: HttpClient) { }

  select(skill: SkillModel) {
    this.selectedSkill.next(skill);
  }

  getAll() {
    this.http.get<SkillModel[]>('http://localhost:8080/getAllSkills.json').subscribe( skillList => {
      this.skillList.next(skillList);
    });
  }

  save(newSkill: SkillModel) {
    this.http.post('http://localhost:8080/saveSkill.json', newSkill).subscribe(() => this.getAll());
  }

  update(existingSkill: SkillModel) {
    this.http.post('http://localhost:8080/updateSkill.json', existingSkill).subscribe( () => this.getAll());
  }

  delete(id: string) {
    this.http.delete('http://localhost:8080/deleteSkill.json', {params: new HttpParams().set('id', id)}).subscribe( () => this.getAll());
  }
}
