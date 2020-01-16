import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {EnumsService} from '../../services/enums.service';
import {SkillModel} from '../../models/skill.model';
import {SkillService} from '../../services/skill.service';
import {v4 as uuid} from 'uuid';

@Component({
  selector: 'app-skill-form',
  templateUrl: './skill-form.component.html',
  styleUrls: ['./skill-form.component.css']
})
export class SkillFormComponent implements OnInit {
  editMode = false;
  selectedSkill: SkillModel;

  skillForm: FormGroup;

  // Backend enums
  difficulties = [];
  abilities = [];

  constructor(private enumsService: EnumsService, private skillService: SkillService) { }

  ngOnInit() {
    this.skillForm = new FormGroup(
      {
        id: new FormControl(null),
        name: new FormControl(null),
        difficulty: new FormControl(null),
        ability: new FormControl(null),
        fullSuccess: new FormControl(null),
        success: new FormControl(null),
        failure: new FormControl(null),
        fatalFailure: new FormControl(null)
      }
    );

    this.skillService.selectedSkill.subscribe( skill => {
      this.editMode = true;
      this.selectedSkill = skill;
      this.fillForm(skill);
    });

    this.enumsService.getDifficulties().subscribe( difficulties => this.difficulties = difficulties);
    this.enumsService.getAbilities().subscribe( abilities => this.abilities = abilities);
  }

  onSubmit() {
    this.save();
  }

  save() {
    this.skillForm.patchValue({id: uuid()});
    this.skillService.save(this.skillForm.value);
    this.clearForm();
  }

  update() {
    this.skillService.update(this.skillForm.value);
    this.clearForm();
  }

  restore() {
    this.fillForm(this.selectedSkill);
  }

  delete() {
    this.skillService.delete(this.selectedSkill.id);
    this.clearForm();
  }

  fillForm(skill: SkillModel) {
    this.skillForm.patchValue(skill);
  }

  clearForm() {
    this.skillForm.reset();
    this.editMode = false;
    this.selectedSkill = null;
  }
}
