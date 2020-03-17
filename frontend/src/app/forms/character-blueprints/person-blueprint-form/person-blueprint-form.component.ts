import {Component, OnInit} from '@angular/core';
import {FormArray, FormControl, FormGroup} from '@angular/forms';
import {PersonBlueprintModel} from '../../../models/person-blueprint.model';
import {PersonBlueprintService} from '../../../services/person-blueprint.service';
import {EnumsService} from '../../../services/enums.service';
import {RaceService} from '../../../services/race.service';
import {RaceModel} from '../../../models/race.model';
import {v4 as uuid} from 'uuid';
import {WeaponBlueprintModel} from '../../../models/weapon-blueprint.model';
import {ArmorBlueprintModel} from '../../../models/armor-blueprint.model';
import {TreasureBlueprintModel} from '../../../models/treasure-blueprint.model';
import {GoodsBlueprintModel} from '../../../models/goods-blueprint.model';

@Component({
  selector: 'app-person-blueprint-form',
  templateUrl: './person-blueprint-form.component.html',
  styleUrls: ['./person-blueprint-form.component.css']
})
export class PersonBlueprintFormComponent implements OnInit {
  // Component controls
  selectedPersonBlueprint: PersonBlueprintModel;
  editMode = false;

  // Backend blueprint list
  races: RaceModel[];

  // Backend enum
  professions: string[];

  // Component forms
  personBlueprintForm: FormGroup;

  constructor(
    private enumsService: EnumsService,
    private raceService: RaceService,
    private personBlueprintService: PersonBlueprintService
  ) {
  }


  ngOnInit(): void {
    this.initForm();

    this.enumsService.getProfessions().subscribe((professions: string[]) => this.professions = professions);

    this.raceService.getAll();
    this.raceService.raceList.subscribe((races: RaceModel[]) => this.races = races);

    this.personBlueprintService.selectedPersonBlueprint.subscribe((personBlueprint: PersonBlueprintModel) => this.fillForm(personBlueprint));
  }

  initForm(): void {
    this.personBlueprintForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl(),
      description: new FormControl(),
      level: new FormControl(),
      profession: new FormControl(),
      race: new FormControl(),
      selectItem: new FormGroup({
        weapon: new FormControl(),
        armor: new FormControl(),
        treasure: new FormControl(),
        good: new FormControl()
      }),
      weaponry: new FormArray([]),
      armory: new FormArray([]),
      treasury: new FormArray([]),
      goods: new FormArray([]),
      gold: new FormControl(),
      silver: new FormControl(),
      copper: new FormControl()
    });
  }

  onSubmit() {
    this.save();
  }

  save() {
    this.personBlueprintForm.patchValue({id: uuid()});
    this.personBlueprintService.save(this.personBlueprintForm.value);
  }

  update() {
    console.log(this.personBlueprintForm.value);
    this.personBlueprintService.update(this.personBlueprintForm.value);
    this.clearForm();
  }

  restore() {
    this.fillForm(this.selectedPersonBlueprint);
  }

  delete() {
    this.personBlueprintService.delete(this.selectedPersonBlueprint.id);
    this.clearForm();
  }

  clearForm(): void {
    this.editMode = false;
    this.selectedPersonBlueprint = null;
    this.personBlueprintForm.reset();
    (this.personBlueprintForm.get('weaponry') as FormArray).clear();
    (this.personBlueprintForm.get('armory') as FormArray).clear();
    (this.personBlueprintForm.get('treasury') as FormArray).clear();
    (this.personBlueprintForm.get('goods') as FormArray).clear();
  }

  private fillForm(personBlueprint: PersonBlueprintModel): void {
    this.clearForm();
    this.editMode = true;
    this.selectedPersonBlueprint = personBlueprint;
    this.personBlueprintForm.patchValue(personBlueprint);
    personBlueprint.weaponry.forEach((weapon: WeaponBlueprintModel) => (this.personBlueprintForm.get('weaponry') as FormArray).push(new FormControl(weapon)));
    personBlueprint.armory.forEach((armor: ArmorBlueprintModel) => (this.personBlueprintForm.get('armory') as FormArray).push(new FormControl(armor)));
    personBlueprint.treasury.forEach((treasure: TreasureBlueprintModel) => (this.personBlueprintForm.get('treasury') as FormArray).push(new FormControl(treasure)));
    personBlueprint.goods.forEach((good: GoodsBlueprintModel) => (this.personBlueprintForm.get('goods') as FormArray).push(new FormControl(good)));
  }
}
