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
    this.weaponFamilyService.weaponFamilyList.subscribe((weaponFamilies: WeaponFamilyModel[]) => this.weaponFamilyDescriptions = weaponFamilies);

    this.weaponBlueprintService.selectedWeaponBlueprint.subscribe( weaponBlueprint => this.fillForm(weaponBlueprint));
  }

  initForm() {
    this.weaponBlueprintForm = new FormGroup(
      {
        id: new FormControl(),
        name: new FormControl(),
        publicDescription: new FormControl(),
        privateDescription: new FormControl(),
        weight: new FormControl(),

        weaponFamily: new FormControl(),

        attack: new FormControl(),
        hurt: new FormControl(),
        defense: new FormControl(),
        initiativeModifier: new FormControl(),

        shortRangeLimit: new FormControl(),
        midRangeLimit: new FormControl(),
        longRangeLimit: new FormControl(),
        minMeleeReach: new FormControl(),
        maxMeleeReach: new FormControl(),
      }
    );
  }

  onSubmit() {}

  save() {
    this.weaponBlueprintForm.patchValue({id: uuid()});
    this.weaponBlueprintService.save(this.weaponBlueprintForm.value);
    this.clearForm();
  }

  update() {
    this.weaponBlueprintService.update(this.weaponBlueprintForm.value);
    this.clearForm();
  }

  delete() {
    this.weaponBlueprintService.delete(this.weaponBlueprintForm.get('id').value);
    this.clearForm();
  }

  fillForm(weaponBlueprint: WeaponBlueprintModel) {
    this.clearForm();
    this.editMode = true;
    this.weaponBlueprintForm.patchValue(weaponBlueprint);
  }

  clearForm() {
    this.editMode = false;
    this.isMelee = true;
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
