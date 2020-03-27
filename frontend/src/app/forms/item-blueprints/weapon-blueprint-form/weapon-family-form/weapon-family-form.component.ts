import {Component, OnDestroy, OnInit} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {EnumsService} from '../../../../services/enums.service';
import {FormArray, FormControl, FormGroup, Validators} from '@angular/forms';
import {WeaponFamilyService} from '../../../../services/weapon-family.service';
import {v4 as uuid} from 'uuid';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-weapon-family-form',
  templateUrl: './weapon-family-form.component.html',
  styleUrls: ['./weapon-family-form.component.css']
})
export class WeaponFamilyFormComponent implements OnInit, OnDestroy {
  private damageSub: Subscription;
  private weightSub: Subscription;

  isMelee = true;
  isSingleHanded = true;

  damageTypes: string[];
  weightCategories: string[];

  weaponFamilyForm: FormGroup;
  damageTypeForm: FormArray;

  constructor(
    public activeModal: NgbActiveModal,
    private enumsService: EnumsService,
    private weaponFamilyService: WeaponFamilyService
  ) {}

  // TODO: Add validations
  ngOnInit() {
    this.damageTypeForm =  new FormArray([]);
    this.weaponFamilyForm = new FormGroup({
      id: new FormControl(uuid()),
      name: new FormControl('', Validators.required),
      weaponType: new FormGroup({
        melee: new FormControl(true),
        singleHanded: new FormControl(true),
        weightCategory: new FormControl(''),
        damageType: this.damageTypeForm
      }),
    });

    this.damageSub = this.enumsService.getWeaponDamageTypes().subscribe((damageTypes: string[]) => this.damageTypes = damageTypes);
    this.weightSub = this.enumsService.getWeightCategories().subscribe((weightCategories: string[]) => this.weightCategories = weightCategories);
  }

  ngOnDestroy(): void {
    this.damageSub.unsubscribe();
    this.weightSub.unsubscribe();
  }

  onSubmit(): void {}

  save() {
    this.weaponFamilyForm.patchValue({id: uuid()});
    this.weaponFamilyService.save(this.weaponFamilyForm.value);
    this.close();
  }

  close(): void {
    this.activeModal.close('Close click');
  }

  // TODO: Make added controls unmodifiable, also do not add already added damage types
  addDamageType(selectedValue: string) {
    this.damageTypeForm.push(new FormControl(selectedValue));
  }

  getDamageTypes() {
    return this.damageTypeForm.controls;
  }

  removeDamageType(index: number) {
    this.damageTypeForm.removeAt(index);
  }
}
