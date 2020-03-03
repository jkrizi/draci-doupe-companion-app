import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {WeaponBlueprintModel} from '../../../models/weapon-blueprint.model';
import {EnumsService} from '../../../services/enums.service';
import {WeaponBlueprintService} from '../../../services/weapon-blueprint.service';
import {v4 as uuid} from 'uuid';
import {WeaponFamilyModel} from '../../../models/weapon-family.model';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {WeaponFamilyFormComponent} from './weapon-family-form/weapon-family-form.component';
import {WeaponFamilyService} from '../../../services/weapon-family.service';

@Component({
  selector: 'app-weapon-blueprint-form',
  templateUrl: './weapon-blueprint-form.component.html',
  styleUrls: ['./weapon-blueprint-form.component.css']
})
export class WeaponBlueprintFormComponent implements OnInit {
  // Component controls
  editMode = false;
  isMelee = true;
  selectedWeaponBlueprint: WeaponBlueprintModel;

  // TODO: Change string so it better describes underlying weaponFamilyId (go to html page to do that)
  // Backend enums
  weaponFamilyDescriptions: WeaponFamilyModel[];

  // Form parts
  weaponBlueprintForm: FormGroup;

  constructor(
    private enumsService: EnumsService,
    private weaponBlueprintService: WeaponBlueprintService,
    private weaponFamilyService: WeaponFamilyService,
    private modalService: NgbModal
  ) {}

  ngOnInit() {
    this.initForm();

    this.weaponFamilyService.getAll();
    this.weaponFamilyService.weaponFamilyList.subscribe((weaponFamilies: WeaponFamilyModel[]) => {
        this.weaponFamilyDescriptions = weaponFamilies;
    });

    this.weaponBlueprintService.selectedWeaponBlueprint.subscribe( weaponBlueprint => {
      this.fillForm(weaponBlueprint);
    });
  }

  initForm() {
    this.weaponBlueprintForm = new FormGroup(
      {
        id: new FormControl(null),
        name: new FormControl(null),
        publicDescription: new FormControl(null),
        privateDescription: new FormControl(null),
        weight: new FormControl(null),

        weaponFamily: new FormControl(null),

        attack: new FormControl(null),
        hurt: new FormControl(null),
        defense: new FormControl(null),
        initiativeModifier: new FormControl(null),

        shortRange: new FormControl(null),
        midRange: new FormControl(null),
        longRange: new FormControl(null),
        minReach: new FormControl(null),
        maxReach: new FormControl(null),
      }
    );
  }

  onSubmit() {
    this.save();
  }

  save() {
    this.weaponBlueprintService.save(this.prepareWeaponBlueprint(uuid()));
    this.clearForm();
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
    const weaponBlueprint: WeaponBlueprintModel = this.weaponBlueprintForm.value;
    weaponBlueprint.id = id;
    return weaponBlueprint;
  }

  fillForm(weaponBlueprint: WeaponBlueprintModel) {
    this.clearForm();
    this.editMode = true;
    this.selectedWeaponBlueprint = weaponBlueprint;
    this.weaponBlueprintForm.patchValue(weaponBlueprint);
  }

  clearForm() {
    this.editMode = false;
    this.isMelee = true;
    this.selectedWeaponBlueprint = null;
    this.weaponBlueprintForm.reset();
  }

  addWeaponFamily() {
    this.modalService.open(WeaponFamilyFormComponent);
  }

  adjustView() {
    if (this.weaponBlueprintForm.get('weaponFamily').value !== null) {
      this.isMelee = this.weaponBlueprintForm.get('weaponFamily').value.weaponType.melee;
    }
  }
}
