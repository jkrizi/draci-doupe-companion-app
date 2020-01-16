import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {EnumsService} from '../../services/enums.service';
import {RaceService} from '../../services/race.service';
import {RaceModel} from '../../models/race.model';
import {WeaponBlueprintService} from '../../services/weapon-blueprint.service';
import {v4 as uuid} from 'uuid';

@Component({
  selector: 'app-race-form',
  templateUrl: './race-form.component.html',
  styleUrls: ['./race-form.component.css']
})
export class RaceFormComponent implements OnInit {
  editMode = false;
  selectedRace: RaceModel;

  raceForm: FormGroup;

  // Backend enums
  sizes: string[];
  racialWeapons: {id: string, name: string}[];

  constructor(private enumsService: EnumsService, private raceService: RaceService, private weaponBlueprintService: WeaponBlueprintService) {
    this.sizes = [];
    this.racialWeapons = [];
  }

  ngOnInit() {
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
        weapon: new FormControl(null),
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

    this.enumsService.getSizes().subscribe( sizes => this.sizes = sizes);
    this.weaponBlueprintService.getAll();
    this.weaponBlueprintService.weaponBlueprintList.subscribe( weaponBlueprints => {
      weaponBlueprints.forEach( weaponBlueprint => {
        this.racialWeapons.push({
          id: weaponBlueprint.id,
          name: weaponBlueprint.name + ' ' + weaponBlueprint.attack + '/' + weaponBlueprint.hurt
        });
      });
    });

    this.raceService.selectedRace.subscribe( race => {
      this.editMode = true;
      this.selectedRace = race;
      this.fillForm(race);
    });
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

  restore() {
    this.fillForm(this.selectedRace);
  }

  delete() {
    this.raceService.delete(this.selectedRace.id);
    this.clearForm();
  }

  //TODO - verify, that the form is filled ocrrectly (restore button is linked to this as well)
  fillForm(raceModel: RaceModel) {
    this.raceForm.patchValue(raceModel);
  }

  clearForm() {
    this.raceForm.reset();
    this.editMode = false;
    this.selectedRace = null;
  }
}
