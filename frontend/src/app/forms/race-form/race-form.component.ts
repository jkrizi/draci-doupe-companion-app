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
  editMode = false;
  
  sizes: string[];
  weaponFamilies: WeaponFamilyModel[];

  raceForm: FormGroup;

  constructor(private enumsService: EnumsService, private raceService: RaceService, private weaponFamilyService: WeaponFamilyService) {}

  ngOnInit() {
    this.initForm();

    this.enumsService.getSizes().subscribe( sizes => this.sizes = sizes);
    this.weaponFamilyService.weaponFamilyList.subscribe( weaponFamilies => this.weaponFamilies = weaponFamilies);

    this.raceService.selectedRace.subscribe( race => this.fillForm(race));
  }

  initForm() {
    this.raceForm = new FormGroup(
      {
        id: new FormControl(),
        name: new FormControl(),
        description: new FormControl(),
        size: new FormControl(),
        minWeight: new FormControl(),
        maxWeight: new FormControl(),
        minHeight: new FormControl(),
        maxHeight: new FormControl(),
        weaponFamilyId: new FormControl(),
        strengthThrows: new FormControl(),
        dexterityThrows: new FormControl(),
        resistanceThrows: new FormControl(),
        intelligenceThrows: new FormControl(),
        charismaThrows: new FormControl(),
        strengthBase: new FormControl(),
        dexterityBase: new FormControl(),
        resistanceBase: new FormControl(),
        intelligenceBase: new FormControl(),
        charismaBase: new FormControl(),
        strengthCorrection: new FormControl(),
        dexterityCorrection: new FormControl(),
        resistanceCorrection: new FormControl(),
        intelligenceCorrection: new FormControl(),
        charismaCorrection: new FormControl()
      }
    );
  }

  onSubmit() {}

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
    this.clearForm();
    this.editMode = true;
    this.raceForm.patchValue(race);
  }

  clearForm() {
    this.raceForm.reset();
    this.editMode = false;
  }
}
