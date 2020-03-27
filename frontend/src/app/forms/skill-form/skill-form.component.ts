import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {EnumsService} from '../../services/enums.service';
import {SkillModel} from '../../models/skill.model';
import {SkillService} from '../../services/skill.service';
import {v4 as uuid} from 'uuid';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-skill-form',
  templateUrl: './skill-form.component.html',
  styleUrls: ['./skill-form.component.css']
})
export class SkillFormComponent implements OnInit, OnDestroy {
  private abilitySub: Subscription;
  private difficultySub: Subscription;
  private listSub: Subscription;

  // Component controls
  editMode = false;

  // Component forms
  skillForm: FormGroup;

  // Backend enums
  difficulties = [];
  abilities = [];

  constructor(private enumsService: EnumsService, private skillService: SkillService) { }

  ngOnInit() {
    this.initForm();

    this.listSub = this.skillService.selectedSkill.subscribe( skill => this.fillForm(skill));

    this.difficultySub = this.enumsService.getDifficulties().subscribe( difficulties => this.difficulties = difficulties);
    this.abilitySub = this.enumsService.getAbilities().subscribe( abilities => this.abilities = abilities);
  }

  ngOnDestroy(): void {
    this.difficultySub.unsubscribe();
    this.abilitySub.unsubscribe();
    this.listSub.unsubscribe();
  }

  initForm() {
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
  }

  onSubmit() {}

  save() {
    this.skillForm.patchValue({id: uuid()});
    this.skillService.save(this.skillForm.value);
    this.clearForm();
  }

  update() {
    this.skillService.update(this.skillForm.value);
    this.clearForm();
  }

  delete() {
    this.skillService.delete(this.skillForm.get('id').value);
    this.clearForm();
  }

  fillForm(skill: SkillModel) {
    this.clearForm();
    this.editMode = true;
    this.skillForm.patchValue(skill);
  }

  clearForm() {
    this.skillForm.reset();
    this.editMode = false;
  }
}
