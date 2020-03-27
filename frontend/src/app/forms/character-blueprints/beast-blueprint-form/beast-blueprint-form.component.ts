import {Component, OnDestroy, OnInit} from '@angular/core';
import {AbstractControl, FormArray, FormControl, FormGroup} from '@angular/forms';
import {BeastBlueprintService} from '../../../services/beast-blueprint.service';
import {BeastBlueprintModel} from '../../../models/beast-blueprint.model';
import {EnumsService} from '../../../services/enums.service';
import {AbilityService} from '../../../services/ability.service';
import {v4 as uuid} from 'uuid';
import {ArmorBlueprintModel} from '../../../models/armor-blueprint.model';
import {WeaponBlueprintModel} from '../../../models/weapon-blueprint.model';
import {GoodsBlueprintModel} from '../../../models/goods-blueprint.model';
import {TreasureBlueprintModel} from '../../../models/treasure-blueprint.model';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-beast-blueprint',
  templateUrl: './beast-blueprint-form.component.html',
  styleUrls: ['./beast-blueprint-form.component.css']
})
export class BeastBlueprintFormComponent implements OnInit, OnDestroy {
  private sizeSub: Subscription;
  private vulnerabilitiesSub: Subscription;
  private listSub: Subscription;

  editMode = false;

  beastBlueprintForm: FormGroup;
  itemSelectorForm: FormGroup;
  abilitiesForm: FormArray = new FormArray([]);
  sizesForm: FormArray = new FormArray([]);
  vulnerabilitiesForm: FormArray = new FormArray([]);

  characterSizes: string[];
  characterVulnerabilities: string[];

  constructor(private beastBlueprintService: BeastBlueprintService, private enumService: EnumsService, private abilityService: AbilityService) {}

  ngOnInit() {
    this.initParentForm();

    this.sizeSub = this.enumService.getSizes().subscribe(sizes => this.characterSizes = sizes);
    this.vulnerabilitiesSub = this.enumService.getVulnerabilities().subscribe(vulnerabilities => this.characterVulnerabilities = vulnerabilities);

    this.listSub = this.beastBlueprintService.selectedBeastBlueprint.subscribe(beastBlueprint => this.fillForm(beastBlueprint));

    this.abilityService.setAbilityValueTracking(this.beastBlueprintForm, 'mobility', 'mobilityBonus');
    this.abilityService.setAbilityValueTracking(this.beastBlueprintForm, 'persistence', 'persistenceBonus');

  }

  ngOnDestroy(): void {
    this.sizeSub.unsubscribe();
    this.vulnerabilitiesSub.unsubscribe();
    this.listSub.unsubscribe();
  }

  initParentForm() {
    this.initAbilityForm();
    this.initItemSelectorForm();

    this.beastBlueprintForm = new FormGroup(
      {
        id: new FormControl(),
        origin: new FormControl(),
        name: new FormControl(),
        species: new FormControl(),
        description: new FormControl(),
        viability: new FormControl(),
        viabilityBonus: new FormControl(),
        manna: new FormControl(),
        mobility: new FormControl(),
        mobilityBonus: new FormControl({value: 0, disabled: true}),
        initiative: new FormControl(),
        persistence: new FormControl(),
        persistenceBonus: new FormControl({value: 0, disabled: true}),
        pugnacity: new FormControl(),
        domestication: new FormControl(),
        schooled: new FormControl(false),

        abilityMap: this.abilitiesForm,
        vulnerabilities: this.vulnerabilitiesForm,
        sizes: this.sizesForm,
        selectItem: this.itemSelectorForm,

        weaponry: new FormArray([]),
        armory: new FormArray([]),
        treasury: new FormArray([]),
        goods: new FormArray([]),
        gold: new FormControl(),
        silver: new FormControl(),
        copper: new FormControl()
      }
    );
  }

  initAbilityForm() {
    this.abilityService.abilities.forEach((singleAbility: string) => this.abilitiesForm.push(
      new FormGroup({
        id: new FormControl(),
        ability: new FormControl(singleAbility),
        abilityValue: new FormControl(),
        abilityBonusValue: new FormControl({value: 0, disabled: true})
      })
    ));
  }

  initItemSelectorForm() {
    this.itemSelectorForm = new FormGroup({
      weapon: new FormControl(),
      armor: new FormControl(),
      treasure: new FormControl(),
      good: new FormControl()
    });
  }

  onSubmit() {}

  save() {
    this.beastBlueprintForm.patchValue({id: uuid()});
    this.abilitiesForm.controls.forEach((abilityGroup: AbstractControl) => abilityGroup.get('id').setValue(uuid()));
    this.beastBlueprintService.save(this.beastBlueprintForm.value);
    this.clearForm();
  }

  update() {
    this.beastBlueprintService.update(this.beastBlueprintForm.value);
    this.clearForm();
  }

  delete() {
    this.beastBlueprintService.delete(this.beastBlueprintForm.get('id').value);
    this.clearForm();
  }

  clearForm() {
    this.editMode = false;
    this.beastBlueprintForm.reset();
    this.sizesForm.clear();
    this.vulnerabilitiesForm.clear();
    // TODO: Could this perhaps be externalized to inventory component? Also used in PersonBlueprint.
    (this.beastBlueprintForm.get('weaponry') as FormArray).clear();
    (this.beastBlueprintForm.get('armory') as FormArray).clear();
    (this.beastBlueprintForm.get('treasury') as FormArray).clear();
    (this.beastBlueprintForm.get('goods') as FormArray).clear();
  }

  fillForm(beastBlueprint: BeastBlueprintModel) {
    this.clearForm();
    this.editMode = true;

    this.beastBlueprintForm.patchValue(beastBlueprint);
    beastBlueprint.sizes.forEach((size: string) => this.updateFormArray(size, this.sizesForm));
    beastBlueprint.vulnerabilities.forEach((vulnerability: string) => this.updateFormArray(vulnerability, this.vulnerabilitiesForm));
    // TODO: Could this perhaps be externalized to inventory component? Also used in PersonBlueprint.
    beastBlueprint.armory.forEach((armorBlueprint: ArmorBlueprintModel) => (this.beastBlueprintForm.get('armory') as FormArray).push(new FormControl(armorBlueprint)));
    beastBlueprint.weaponry.forEach((weaponBlueprint: WeaponBlueprintModel) => (this.beastBlueprintForm.get('weaponry') as FormArray).push(new FormControl(weaponBlueprint)));
    beastBlueprint.goods.forEach((goodsBlueprint: GoodsBlueprintModel) => (this.beastBlueprintForm.get('goods') as FormArray).push(new FormControl(goodsBlueprint)));
    beastBlueprint.treasury.forEach((treasuryBlueprint: TreasureBlueprintModel) => (this.beastBlueprintForm.get('treasury') as FormArray).push(new FormControl(treasuryBlueprint)));
  }

  findIndex(formValue: any, formArray: FormArray): number {
    return formArray.controls.findIndex((control: AbstractControl) => control.value === formValue);
}

  updateFormArray(formValue: any, formArray: FormArray) {
    const index = this.findIndex(formValue, formArray);
    if (index === -1) {
      formArray.push(new FormControl(formValue));
    } else {
      formArray.removeAt(index);
    }
  }
}
