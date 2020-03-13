import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormArray, FormControl, FormGroup} from '@angular/forms';
import {SwordMoveService} from '../../services/sword-move.service';
import {SwordMoveModel} from '../../models/sword-move.model';
import {v4 as uuid} from 'uuid';
import {WeaponFamilyService} from '../../services/weapon-family.service';
import {WeaponFamilyModel} from '../../models/weapon-family.model';

@Component({
  selector: 'app-sword-move-form',
  templateUrl: './sword-move-form.component.html',
  styleUrls: ['./sword-move-form.component.css']
})
export class SwordMoveFormComponent implements OnInit {
  editMode = false;
  selectedSwordMove: SwordMoveModel;

  weaponFamilies: WeaponFamilyModel[];

  swordMoveForm: FormGroup;
  userWeaponsForm: FormArray;
  opponentWeaponsForm: FormArray;

  constructor(
    private swordMoveService: SwordMoveService,
    private weaponFamilyService: WeaponFamilyService
  ) {
    this.weaponFamilies = [];
  }

  ngOnInit() {
    this.initForm();

    this.weaponFamilyService.getAll();
    this.weaponFamilyService.weaponFamilyList.subscribe((weaponFamilies: WeaponFamilyModel[]) => this.weaponFamilies = weaponFamilies);

    this.swordMoveService.selectedSwordMove.subscribe( swordMove => this.fillForm(swordMove));
  }

  initForm(): void {
    this.userWeaponsForm = new FormArray([]);
    this.opponentWeaponsForm = new FormArray([]);

    this.swordMoveForm = new FormGroup(
      {
        id: new FormControl(null),
        name: new FormControl(null),
        initiative: new FormControl(null),
        actions: new FormControl(null),
        description: new FormControl(null),
        humanoidOpponent: new FormControl(false),
        allowedUserWeapons: this.userWeaponsForm,
        allowedOpponentWeapons: this.opponentWeaponsForm
      }
    );
  }

  onSubmit(): void {
    this.save();
  }

  save(): void {
    this.swordMoveForm.get('id').patchValue(uuid());
    this.swordMoveService.save(this.swordMoveForm.value);
    this.clearForm();
  }

  update(): void {
    this.swordMoveService.update(this.swordMoveForm.value);
    this.clearForm();
  }

  restore(): void {
    this.fillForm(this.selectedSwordMove);
  }

  delete(): void {
    this.swordMoveService.delete(this.selectedSwordMove.id);
    this.clearForm();
  }

  fillForm(swordMove: SwordMoveModel): void {
    this.clearForm();
    this.editMode = true;
    this.selectedSwordMove = swordMove;
    this.swordMoveForm.patchValue(swordMove);
    swordMove.allowedUserWeapons.forEach( userWeaponFamily => this.userWeaponsForm.push(new FormControl(userWeaponFamily)));
    swordMove.allowedOpponentWeapons.forEach( opponentWeaponFamily => this.opponentWeaponsForm.push(new FormControl(opponentWeaponFamily)));
  }

  clearForm(): void {
    this.swordMoveForm.reset();
    this.userWeaponsForm.clear();
    this.opponentWeaponsForm.clear();
    this.editMode = false;
    this.selectedSwordMove = null;
  }

  updateWeapons(weaponsFormArray: FormArray, weaponFamily: WeaponFamilyModel): void {
    const weaponIndex = this.findWeaponIndex(weaponsFormArray, weaponFamily);
    if ( weaponIndex === -1) {
      weaponsFormArray.push(new FormControl(weaponFamily));
    } else {
      weaponsFormArray.removeAt(weaponIndex);
    }
  }

  findWeaponIndex(weaponsFormArray: FormArray, weaponFamily: WeaponFamilyModel): number {
    return weaponsFormArray.controls.findIndex((control: AbstractControl) => control.value.id === weaponFamily.id);
  }
}
