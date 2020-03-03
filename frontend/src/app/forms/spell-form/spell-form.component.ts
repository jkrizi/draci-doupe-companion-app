import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {SpellModel} from '../../models/spell.model';
import {SpellService} from '../../services/spell.service';
import {v4 as uuid} from 'uuid';


@Component({
  selector: 'app-spell-form',
  templateUrl: './spell-form.component.html',
  styleUrls: ['./spell-form.component.css']
})
export class SpellFormComponent implements OnInit {
  // Component controls
  editMode = false;
  selectedSpell: SpellModel;

  // Component forms
  spellForm: FormGroup;

  constructor(private spellService: SpellService) { }

  ngOnInit() {
    this.initForm();
    this.spellService.selectedSpell.subscribe( spell => this.fillForm(spell));
  }

  initForm() {
    this.spellForm = new FormGroup(
      {
        id: new FormControl(null),
        name: new FormControl(null),
        description: new FormControl(null),
        manna: new FormControl(null),
        range: new FormControl(null),
        conjuring: new FormControl(null),
        duration: new FormControl(null)
      }
    );
  }

  onSubmit() {
    this.save();
  }

  save() {
    this.spellForm.patchValue({id: uuid()});
    this.spellService.save(this.spellForm.value);
    this.clearForm();
  }

  update() {
    this.spellService.update(this.spellForm.value);
    this.clearForm();
  }

  restore() {
    this.fillForm(this.selectedSpell);
  }

  delete() {
    this.spellService.delete(this.selectedSpell.id);
    this.clearForm();
  }

  fillForm(spell: SpellModel) {
    this.editMode = true;
    this.selectedSpell = spell;
    this.spellForm.patchValue(spell);
  }

  clearForm() {
    this.spellForm.reset();
    this.selectedSpell = null;
    this.editMode = false;
  }
}
