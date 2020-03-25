import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
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
  bodyCoverageForm: FormGroup;

  constructor(private enumsService: EnumsService, private armorBlueprintService: ArmorBlueprintService) {
    this.bodyCoverage = [];
    this.sizes = [];
  }

  ngOnInit() {
    this.bodyCoverageForm =  new FormGroup({});
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

    this.enumsService.getSizes().subscribe( sizes => this.sizes = sizes);

    this.enumsService.getBodySections().subscribe(bodySections => {
      bodySections.forEach( bodySection => {
        this.bodyCoverage.push(bodySection);
        this.bodyCoverageForm.addControl(bodySection, new FormControl(false));
      });
    });

    this.armorBlueprintService.selectedArmorBlueprint.subscribe( selectedArmorBlueprint => {
      this.fillForm(selectedArmorBlueprint);
    });
  }

  onSubmit() {
    this.save();
  }

  save() {
    this.armorBlueprintService.save(this.prepareArmorBlueprint(uuid()));
    this.clearForm();
  }

  update() {
    this.armorBlueprintService.update(this.prepareArmorBlueprint(this.armorBlueprintForm.get('id').value));
    this.clearForm();
  }

  delete() {
    this.armorBlueprintService.delete(this.armorBlueprintForm.get('id').value);
    this.clearForm();
  }

  fillForm(selectedArmorBlueprint: ArmorBlueprintModel) {
    this.clearForm();
    this.editMode = true;
    this.armorBlueprintForm.patchValue(selectedArmorBlueprint);
    selectedArmorBlueprint.coverage.forEach( coverage => {
      this.bodyCoverageForm.get(coverage).setValue(true);
    });
  }

  clearForm() {
    this.editMode = false;
    this.armorBlueprintForm.reset();
  }

  private prepareArmorBlueprint(id: string): ArmorBlueprintModel {
    const armorBlueprint: ArmorBlueprintModel = this.armorBlueprintForm.value;
    armorBlueprint.id = id;
    armorBlueprint.coverage = [];
    this.bodyCoverage.forEach( bodySection => {
      if (this.bodyCoverageForm.get(bodySection).value) {
        armorBlueprint.coverage.push(bodySection);
      }
    });
    return armorBlueprint;
  }
}
