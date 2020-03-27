import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormArray, FormControl, FormGroup} from '@angular/forms';
import {ArmorBlueprintModel} from '../../../models/armor-blueprint.model';
import {EnumsService} from '../../../services/enums.service';
import {ArmorBlueprintService} from '../../../services/armor-blueprint.service';
import {v4 as uuid} from 'uuid';

@Component({
  selector: 'app-armor-blueprint-form',
  templateUrl: './armor-blueprint-form.component.html',
  styleUrls: ['./armor-blueprint-form.component.css']
})
export class ArmorBlueprintFormComponent implements OnInit {
  editMode = false;

  // Backend enums
  bodyCoverage: string[];
  sizes: string[];

  armorBlueprintForm: FormGroup;
  bodyCoverageForm: FormArray;

  constructor(private enumsService: EnumsService, private armorBlueprintService: ArmorBlueprintService) {}

  ngOnInit() {
    this.initForm();

    this.enumsService.getSizes().subscribe( sizes => this.sizes = sizes);

    this.enumsService.getBodySections().subscribe(bodySections => {this.bodyCoverage = bodySections;});

    this.armorBlueprintService.selectedArmorBlueprint.subscribe( selectedArmorBlueprint => {
      this.fillForm(selectedArmorBlueprint);
    });
  }

  initForm() {
    this.bodyCoverageForm =  new FormArray([]);
    this.armorBlueprintForm = new FormGroup(
      {
        id: new FormControl(null),
        name: new FormControl(null),
        publicDescription: new FormControl(null),
        privateDescription: new FormControl(null),
        armorSize: new FormControl(null),
        weight: new FormControl(null),
        defense: new FormControl(null),
        bodyCoverage: this.bodyCoverageForm
      }
    );
  }

  onSubmit(): void {}

  save(): void {
    this.armorBlueprintForm.patchValue({id: uuid()});
    this.armorBlueprintService.save(this.armorBlueprintForm.value);
    this.clearForm();
  }

  update(): void {
    this.armorBlueprintService.update(this.armorBlueprintForm.value);
    this.clearForm();
  }

  delete(): void {
    this.armorBlueprintService.delete(this.armorBlueprintForm.get('id').value);
    this.clearForm();
  }

  fillForm(selectedArmorBlueprint: ArmorBlueprintModel) {
    this.clearForm();
    this.editMode = true;
    this.armorBlueprintForm.patchValue(selectedArmorBlueprint);
    selectedArmorBlueprint.coverage.forEach( coverage => {
      this.bodyCoverageForm.push(new FormControl(coverage));
    });
  }

  clearForm(): void {
    this.editMode = false;
    this.armorBlueprintForm.reset();
    this.bodyCoverageForm.clear();
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
