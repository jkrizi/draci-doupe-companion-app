import {Component, OnDestroy, OnInit} from '@angular/core';
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
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-person-blueprint-form',
  templateUrl: './person-blueprint-form.component.html',
  styleUrls: ['./person-blueprint-form.component.css']
})
export class PersonBlueprintFormComponent implements OnInit, OnDestroy {
  private professionSub: Subscription;
  private raceSub: Subscription;
  private listSub: Subscription;

  editMode = false;

  races: RaceModel[];
  professions: string[];

  personBlueprintForm: FormGroup;

  constructor(private enumsService: EnumsService, private raceService: RaceService, private personBlueprintService: PersonBlueprintService) {}

  ngOnInit(): void {
    this.initForm();

    this.professionSub = this.enumsService.getProfessions().subscribe((professions: string[]) => this.professions = professions);

    this.raceService.getAll();
    this.raceSub = this.raceService.raceList.subscribe((races: RaceModel[]) => this.races = races);

    this.listSub = this.personBlueprintService.selectedPersonBlueprint.subscribe((personBlueprint: PersonBlueprintModel) => this.fillForm(personBlueprint));
  }

  ngOnDestroy(): void {
    this.professionSub.unsubscribe();
    this.raceSub.unsubscribe();
    this.listSub.unsubscribe();
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

  onSubmit() {}

  save() {
    this.personBlueprintForm.patchValue({id: uuid()});
    this.personBlueprintService.save(this.personBlueprintForm.value);
    this.clearForm();
  }

  update() {
    this.personBlueprintService.update(this.personBlueprintForm.value);
    this.clearForm();
  }

  delete() {
    this.personBlueprintService.delete(this.personBlueprintForm.get('id').value);
    this.clearForm();
  }

  clearForm(): void {
    this.editMode = false;
    this.personBlueprintForm.reset();
    (this.personBlueprintForm.get('weaponry') as FormArray).clear();
    (this.personBlueprintForm.get('armory') as FormArray).clear();
    (this.personBlueprintForm.get('treasury') as FormArray).clear();
    (this.personBlueprintForm.get('goods') as FormArray).clear();
  }

  private fillForm(personBlueprint: PersonBlueprintModel): void {
    this.clearForm();
    this.editMode = true;
    this.personBlueprintForm.patchValue(personBlueprint);
    personBlueprint.weaponry.forEach((weapon: WeaponBlueprintModel) => (this.personBlueprintForm.get('weaponry') as FormArray).push(new FormControl(weapon)));
    personBlueprint.armory.forEach((armor: ArmorBlueprintModel) => (this.personBlueprintForm.get('armory') as FormArray).push(new FormControl(armor)));
    personBlueprint.treasury.forEach((treasure: TreasureBlueprintModel) => (this.personBlueprintForm.get('treasury') as FormArray).push(new FormControl(treasure)));
    personBlueprint.goods.forEach((good: GoodsBlueprintModel) => (this.personBlueprintForm.get('goods') as FormArray).push(new FormControl(good)));
  }
}
