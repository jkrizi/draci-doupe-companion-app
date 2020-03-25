import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {EnumsService} from '../../services/enums.service';
import {RaceService} from '../../services/race.service';
import {RaceModel} from '../../models/race.model';
import {v4 as uuid} from 'uuid';
import {WeaponFamilyService} from '../../services/weapon-family.service';
import {WeaponFamilyModel} from '../../models/weapon-family.model';

@Component({
  selector: 'app-race-form',
  templateUrl: './race-form.component.html',
  styleUrls: ['./race-form.component.css']
})
export class RaceFormComponent implements OnInit {
  // Component controls
  editMode = false;

  raceForm: FormGroup;

  // Backend enums
  sizes: string[];

  // Blueprint lists
  weaponFamilies: WeaponFamilyModel[];

  constructor(
    private enumsService: EnumsService,
    private raceService: RaceService,
    private weaponFamilyService: WeaponFamilyService
  ) {}

  ngOnInit() {
    this.initForm();

    this.enumsService.getSizes().subscribe( sizes => this.sizes = sizes);
    this.weaponFamilyService.getAll();
    this.weaponFamilyService.weaponFamilyList.subscribe( weaponFamilies => this.weaponFamilies = weaponFamilies);

    this.raceService.selectedRace.subscribe( race => this.fillForm(race));
  }

  initForm() {
    this.raceForm = new FormGroup(
      {
        id: new FormControl(null),
        name: new FormControl(null),
        description: new FormControl(null),
        size: new FormControl(null),
        minWeight: new FormControl(null),
        maxWeight: new FormControl(null),
        minHeight: new FormControl(null),
        maxHeight: new FormControl(null),
        weaponFamilyId: new FormControl(null),
        strengthThrows: new FormControl(null),
        dexterityThrows: new FormControl(null),
        resistanceThrows: new FormControl(null),
        intelligenceThrows: new FormControl(null),
        charismaThrows: new FormControl(null),
        strengthBase: new FormControl(null),
        dexterityBase: new FormControl(null),
        resistanceBase: new FormControl(null),
        intelligenceBase: new FormControl(null),
        charismaBase: new FormControl(null),
        strengthCorrection: new FormControl(null),
        dexterityCorrection: new FormControl(null),
        resistanceCorrection: new FormControl(null),
        intelligenceCorrection: new FormControl(null),
        charismaCorrection: new FormControl(null)
      }
    );
  }

  onSubmit() {
    this.save();
  }

  save() {
    this.raceForm.patchValue({id: uuid()});
    this.raceService.save(this.raceForm.value);
    this.clearForm();
  }

  update() {
    this.raceService.update(this.raceForm.value);
    this.clearForm();
  }

  delete() {
    this.raceService.delete(this.raceForm.get('id').value);
    this.clearForm();
  }

  fillForm(race: RaceModel) {
    this.editMode = true;
    this.raceForm.patchValue(race);
  }

  clearForm() {
    this.raceForm.reset();
    this.editMode = false;
  }
}
