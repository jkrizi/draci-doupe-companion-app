import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {SpellModel} from '../../models/spell.model';
import {SpellService} from '../../services/spell.service';
import {v4 as uuid} from 'uuid';
import {Subscription} from 'rxjs';


@Component({
  selector: 'app-spell-form',
  templateUrl: './spell-form.component.html',
  styleUrls: ['./spell-form.component.css']
})
export class SpellFormComponent implements OnInit, OnDestroy {
  private listSub: Subscription;

  // Component controls
  editMode = false;

  // Component forms
  spellForm: FormGroup;

  constructor(private spellService: SpellService) { }

  ngOnInit() {
    this.initForm();
    this.listSub = this.spellService.selectedSpell.subscribe( spell => this.fillForm(spell));
  }

  ngOnDestroy(): void {
    this.listSub.unsubscribe();
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

  onSubmit() {}

  save() {
    this.spellForm.patchValue({id: uuid()});
    this.spellService.save(this.spellForm.value);
    this.clearForm();
  }

  update() {
    this.spellService.update(this.spellForm.value);
    this.clearForm();
  }

  delete() {
    this.spellService.delete(this.spellForm.get('id').value);
    this.clearForm();
  }

  fillForm(spell: SpellModel) {
    this.editMode = true;
    this.spellForm.patchValue(spell);
  }

  clearForm() {
    this.spellForm.reset();
    this.editMode = false;
  }
}
