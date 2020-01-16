import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {WeaponBlueprintModel} from '../../../models/weapon-blueprint.model';
import {EnumsService} from '../../../services/enums.service';
import {WeaponBlueprintService} from '../../../services/weapon-blueprint.service';
import {v4 as uuid} from 'uuid';

@Component({
  selector: 'app-weapon-blueprint-form',
  templateUrl: './weapon-blueprint-form.component.html',
  styleUrls: ['./weapon-blueprint-form.component.css']
})
export class WeaponBlueprintFormComponent implements OnInit {
  editMode = false;
  melee = true;
  selectedWeaponBlueprint: WeaponBlueprintModel;

  weaponTypes: string[];

  weaponBlueprintForm: FormGroup;
  weaponTypesForm: FormGroup;

  constructor(private enumsService: EnumsService, private weaponBlueprintService: WeaponBlueprintService) {
    this.weaponTypes = [];
  }

  ngOnInit() {
    this.weaponTypesForm = new FormGroup({});
    this.weaponBlueprintForm = new FormGroup(
      {
        id: new FormControl(null),
        name: new FormControl(null),
        publicDescription: new FormControl(null),
        privateDescription: new FormControl(null),
        weight: new FormControl(null),
        melee: new FormControl(true),
        attack: new FormControl(null),
        hurt: new FormControl(null),
        defense: new FormControl(null),
        initiative: new FormControl(null),
        shortRange: new FormControl(null),
        midRange: new FormControl(null),
        longRange: new FormControl(null),
        minReach: new FormControl(null),
        maxReach: new FormControl(null),
        weaponTypes: this.weaponTypesForm
      }
    );

    this.enumsService.getWeaponTypes().subscribe( weaponTypes => {
      weaponTypes.forEach( weaponType => {
        this.weaponTypes.push(weaponType);
        this.weaponTypesForm.addControl(weaponType, new FormControl(false));
      });
    });

    this.weaponBlueprintService.selectedWeaponBlueprint.subscribe( weaponBlueprint => {
      this.clearForm();
      this.editMode = true;
      this.selectedWeaponBlueprint = weaponBlueprint;
      this.fillForm(weaponBlueprint);
    });
  }

  onSubmit() {
    this.save();
  }

  save() {
    this.weaponBlueprintService.save(this.prepareWeaponBlueprint(uuid()));
    // this.clearForm();
  }

  update() {
    this.weaponBlueprintService.update(this.prepareWeaponBlueprint(this.selectedWeaponBlueprint.id));
    this.clearForm();
  }

  restore() {
    this.fillForm(this.selectedWeaponBlueprint);
  }

  delete() {
    this.weaponBlueprintService.delete(this.selectedWeaponBlueprint.id);
    this.clearForm();
  }

  prepareWeaponBlueprint(id: string): WeaponBlueprintModel {

    const newWeaponBlueprint: WeaponBlueprintModel = this.weaponBlueprintForm.value;
    newWeaponBlueprint.weaponTypes = [];
    newWeaponBlueprint.id = id;
    this.weaponTypes.forEach( weaponType => {
      if (this.weaponTypesForm.get(weaponType).value) {
        newWeaponBlueprint.weaponTypes.push(weaponType);
      }
    });
    return newWeaponBlueprint;
  }

  fillForm(weaponBlueprint: WeaponBlueprintModel) {
    weaponBlueprint.weaponTypes.forEach( weaponType => {
      this.weaponTypesForm.get(weaponType).setValue(true);
    });
    this.weaponBlueprintForm.patchValue(weaponBlueprint);
  }

  clearForm() {
    this.editMode = false;
    this.selectedWeaponBlueprint = null;
    this.weaponBlueprintForm.reset();
  }
}
