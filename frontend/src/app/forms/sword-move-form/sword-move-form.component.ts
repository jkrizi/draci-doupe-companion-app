import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {EnumsService} from '../../services/enums.service';
import {SwordMoveService} from '../../services/sword-move.service';
import {SwordMoveModel} from '../../models/sword-move.model';
import {v4 as uuid} from 'uuid';

@Component({
  selector: 'app-sword-move-form',
  templateUrl: './sword-move-form.component.html',
  styleUrls: ['./sword-move-form.component.css']
})
export class SwordMoveFormComponent implements OnInit {
  editMode = false;
  selectedSwordMove: SwordMoveModel;

  weaponTypes: string[];

  swordMoveForm: FormGroup;
  userWeaponTypes: FormGroup;
  opponentWeaponTypes: FormGroup;

  constructor(private enumsService: EnumsService, private swordMoveService: SwordMoveService) {
    this.weaponTypes = [];
  }

  ngOnInit() {
    this.userWeaponTypes = new FormGroup({});
    this.opponentWeaponTypes = new FormGroup({});

    this.swordMoveForm = new FormGroup(
      {
        id: new FormControl(null),
        name: new FormControl(null),
        initiativeModifier: new FormControl(null),
        actions: new FormControl(null),
        description: new FormControl(null),
        humanoidOpponent: new FormControl(false),
        userWeapon: this.userWeaponTypes,
        opponentWeapon: this.opponentWeaponTypes
      }
    );

    // this.enumsService.getWeaponTypes().subscribe( weaponTypes => {
    //   weaponTypes.forEach(weaponType => {
    //     this.weaponTypes.push(weaponType);
    //     this.userWeaponTypes.addControl(weaponType, new FormControl(false));
    //     this.opponentWeaponTypes.addControl(weaponType, new FormControl(false));
    //   });
    // });

    this.swordMoveService.selectedSwordMove.subscribe( swordMove => {
      this.clearForm();
      this.editMode = true;
      this.selectedSwordMove = swordMove;
      this.fillForm(swordMove);
    });
  }

  onSubmit() {
    this.save();
  }

  save() {
    this.swordMoveService.save(this.prepareSwordMove(uuid()));
    this.clearForm();
  }

  update() {
    this.swordMoveService.update(this.prepareSwordMove(this.selectedSwordMove.id));
    this.clearForm();
  }

  restore() {
    this.fillForm(this.selectedSwordMove);
  }

  delete() {
    this.swordMoveService.delete(this.selectedSwordMove.id);
    this.clearForm();
  }

  prepareSwordMove(id: string): SwordMoveModel {
    const swordMove: SwordMoveModel = this.swordMoveForm.value;
    swordMove.id = id;
    swordMove.userWeaponTypes = [];
    swordMove.opponentWeaponTypes = [];
    this.weaponTypes.forEach( weaponType => {
      if (this.userWeaponTypes.get(weaponType).value) {
        swordMove.userWeaponTypes.push(weaponType);
      }
      if (this.opponentWeaponTypes.get(weaponType).value) {
        swordMove.opponentWeaponTypes.push(weaponType);
      }
    });
    return swordMove;
  }

  fillForm(swordMove: SwordMoveModel) {
    this.swordMoveForm.patchValue(swordMove);
    swordMove.userWeaponTypes.forEach( userWeaponType => {
      this.userWeaponTypes.get(userWeaponType).setValue(true);
    });
    swordMove.opponentWeaponTypes.forEach( opponentWeaponType => {
      this.opponentWeaponTypes.get(opponentWeaponType).setValue(true);
    });
  }

  clearForm() {
    this.swordMoveForm.reset();
    this.editMode = false;
    this.selectedSwordMove = null;
  }
}
