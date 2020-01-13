import {Component, OnInit} from '@angular/core';
import {FormArray, FormControl, FormGroup} from '@angular/forms';
import {BeastBlueprintService} from '../../../services/beast-blueprint.service';
import {BeastBlueprintModel} from '../../../models/beast-blueprint.model';
import {EnumsService} from '../../../services/enums.service';
import {AbilityService} from '../../../services/ability.service';
import {CombatValuesService} from '../../../services/combat-values.service';
import {InventoryService} from '../../../services/inventory.service';

@Component({
  selector: 'app-beast-blueprint',
  templateUrl: './beast-blueprint.component.html',
  styleUrls: ['./beast-blueprint.component.css']
})
export class BeastBlueprintComponent implements OnInit {
  editMode = false;
  editedBlueprint: BeastBlueprintModel;

  beastBlueprintForm: FormGroup;

  characterSizes: { name: string, status: boolean }[] = [];
  characterVulnerabilities: { name: string, status: boolean }[] = [];

  constructor(
    private beastBlueprintService: BeastBlueprintService,
    private enumService: EnumsService,
    private abilityService: AbilityService,
    private combatValuesService: CombatValuesService,
    private inventoryService: InventoryService) {
  }

  ngOnInit() {

    this.beastBlueprintForm = new FormGroup(
      {
        name: new FormControl(null),
        description: new FormControl(null),
        origin: new FormControl(null),
        species: new FormControl(null),
        schooled: new FormControl(false),
        viability: new FormControl(null),
        viabilityBonus: new FormControl(null),
        manna: new FormControl(null),
        mobility: new FormControl(null),
        persistence: new FormControl(null),
        pugnacity: new FormControl(null),
        domestication: new FormControl(null),

        abilityMap: new FormGroup({
          strength: new FormControl(null),
          dexterity: new FormControl(null),
          resistance: new FormControl(null),
          intelligence: new FormControl(null),
          charisma: new FormControl(null),
        }),

        combatValues: new FormGroup({
          initiativeBase: new FormControl(null),
        }),

        inventory: new FormGroup({
          weaponry: new FormArray([]),
          armory: new FormArray([]),
          treasury: new FormArray([]),
          goods: new FormArray([]),
          goldCoin: new FormControl(null),
          silverCoin: new FormControl(null),
          bronzeCoin: new FormControl(null)
        })
      }
    );

    this.enumService.getSizes().subscribe(sizes => {
      sizes.forEach(size => this.characterSizes.push({name: size, status: false}));
    });

    this.enumService.getVulnerabilities().subscribe(vulnerabilities => {
      vulnerabilities.forEach(vulnerability => this.characterVulnerabilities.push({name: vulnerability, status: false}));
    });

    this.beastBlueprintService.selectedBlueprint.subscribe(beastBlueprint => {
      this.editMode = true;
      this.editedBlueprint = beastBlueprint;
      this.fillForm(beastBlueprint);
    });
  }

  onSubmit() {

  }

  cleanForm() {
    this.characterSizes.forEach(size => {
      size.status = false;
    });

    this.characterVulnerabilities.forEach(vulnerability => {
      vulnerability.status = false;
    });
  }

  fillForm(beastBlueprint: BeastBlueprintModel) {
    this.cleanForm();
    this.inventoryService.fillInventoryForm(beastBlueprint.inventory);
    this.abilityService.fillAbilityForm(beastBlueprint.abilityMap);
    this.combatValuesService.fillCombatValues(beastBlueprint.combatValues);

    this.beastBlueprintForm.patchValue({
      name: beastBlueprint.name,
      description: beastBlueprint.description,
      origin: beastBlueprint.origin,
      species: beastBlueprint.species,
      schooled: beastBlueprint.schooled,
      viability: beastBlueprint.viability,
      viabilityBonus: beastBlueprint.viabilityBonus,
      manna: beastBlueprint.manna,
      mobility: beastBlueprint.mobility,
      persistence: beastBlueprint.persistence,
      pugnacity: beastBlueprint.pugnacity,
      domestication: beastBlueprint.domestication,
    });

    this.characterSizes.forEach(size => {
      size.status = (beastBlueprint.sizes.includes(size.name, 0));
    });

    this.characterVulnerabilities.forEach(vulnerability => {
      vulnerability.status = (beastBlueprint.vulnerabilities.includes(vulnerability.name, 0));
    });
  }
}
