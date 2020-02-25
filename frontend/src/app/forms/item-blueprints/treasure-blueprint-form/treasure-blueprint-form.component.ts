import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormArray, FormControl, FormGroup} from '@angular/forms';
import {TreasureBlueprintModel} from '../../../models/treasure-blueprint.model';
import {EnumsService} from '../../../services/enums.service';
import {TreasureBlueprintService} from '../../../services/treasure-blueprint.service';
import {GemstoneBlueprintModel} from '../../../models/gemstone-blueprint.model';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {GemstoneBlueprintFormComponent} from './gemstone-blueprint-form/gemstone-blueprint-form.component';
import {GemstoneBlueprintService} from '../../../services/gemstone-blueprint.service';
import {v4 as uuid} from 'uuid';

@Component({
  selector: 'app-treasure-blueprint-form',
  templateUrl: './treasure-blueprint-form.component.html',
  styleUrls: ['./treasure-blueprint-form.component.css']
})
export class TreasureBlueprintFormComponent implements OnInit, OnDestroy {
  // Component controls
  editMode = false;
  selectedTreasureBlueprint: TreasureBlueprintModel;

  // Backend enums
  materials: string[];
  qualityScale: string[];
  colors: string[];

  // TODO: Solve issue of repeating gemstone names and related color filter base on selected stone
  // Blueprint lists
  filteredGemstones: GemstoneBlueprintModel[];
  unfilteredGemstones: GemstoneBlueprintModel[];

  // Form parts
  treasureBlueprintForm: FormGroup;
  currGemForm: FormGroup;
  gemStones: FormArray;

  constructor(
    private enumsService: EnumsService,
    private treasureBlueprintService: TreasureBlueprintService,
    private gemstoneBlueprintService: GemstoneBlueprintService,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.initParentForm();

    this.enumsService.getMaterials().subscribe((materials: string[]) => {
      this.materials = materials;
    });
    this.enumsService.getQualityLevels().subscribe((qualityLevels: string[]) => {
      this.qualityScale = qualityLevels;
    });
    this.enumsService.getColors().subscribe((colors: string[]) => {
      this.colors = colors;
    });

    this.gemstoneBlueprintService.getAll();
    this.gemstoneBlueprintService.gemstoneBlueprintsList.subscribe((gemstoneBlueprints: GemstoneBlueprintModel[]) => {
      this.unfilteredGemstones = gemstoneBlueprints;
      this.filteredGemstones = gemstoneBlueprints;
    });

    this.treasureBlueprintService.selectedTreasureBlueprint.subscribe(selectedTreasureBlueprint => this.fillForm(selectedTreasureBlueprint));
  }

  initParentForm(): void {
    this.initChildForm();
    this.treasureBlueprintForm = new FormGroup(
      {
        id: new FormControl(null),
        name: new FormControl(null),
        publicDescription: new FormControl(null),
        privateDescription: new FormControl(null),
        weight: new FormControl(null),
        currGem: this.currGemForm,
        gemStones: this.gemStones,
        // TODO: Material could be array in same regard as Gemstone
        material: new FormGroup({
          type: new FormControl(null),
          quality: new FormControl(null),
          weight: new FormControl(null),
        }),
        // TODO: Consider hiding/removing etc. if any gemstone or material is present
        goldCoins: new FormControl(null),
        silverCoins: new FormControl(null),
        copperCoins: new FormControl(null)
      }
    );
  }

  // TODO: Why cant I call this instead of initParent form after save/update?
  initChildForm(): void {
    this.gemStones = new FormArray([]);
    this.currGemForm = new FormGroup({
      currGemColor: new FormControl(null),
      currGemStone: new FormControl(null),
      currGemWeight: new FormControl(null),
      currGemCount: new FormControl(null),
      currGemPolished: new FormControl(null)
    });
  }


  // TODO: If necessary add unsubscribe
  ngOnDestroy(): void {

  }

  onSubmit(): void {
    this.save();
  }

  save(): void {
    this.treasureBlueprintService.save(this.prepareTreasureBlueprint(uuid()));
    this.initParentForm();
    this.clearForm();
  }

  update(): void {
    this.treasureBlueprintService.update(this.prepareTreasureBlueprint(this.selectedTreasureBlueprint.id));
    this.initParentForm();
    this.clearForm();
  }

  prepareTreasureBlueprint(id: string): TreasureBlueprintModel {
    this.treasureBlueprintForm.removeControl('currGem');
    const treasureBlueprint = this.treasureBlueprintForm.value;
    treasureBlueprint.id = id;
    return treasureBlueprint;
  }

  restore(): void {
    this.fillForm(this.selectedTreasureBlueprint);
  }

  delete(): void {
    this.treasureBlueprintService.delete(this.selectedTreasureBlueprint.id);
    this.clearForm();
  }

  // TODO: Check filling logic
  fillForm(treasureBlueprint: TreasureBlueprintModel) {
    this.clearForm();
    this.editMode = true;
    this.selectedTreasureBlueprint = treasureBlueprint;
    this.treasureBlueprintForm.patchValue(treasureBlueprint);
  }

  clearForm() {
    this.editMode = false;
    this.selectedTreasureBlueprint = null;
    this.treasureBlueprintForm.reset();
  }

  addGemstone() {
    const currGemstoneBlueprint = this.unfilteredGemstones.find((gemstoneBlueprint: GemstoneBlueprintModel) => gemstoneBlueprint.id === this.currGemForm.get('currGemStone').value);

    this.gemStones.push(new FormGroup({
      id: new FormControl(currGemstoneBlueprint.id),
      color: new FormControl({value: this.currGemForm.get('currGemColor').value, disabled: true}),
      stone: new FormControl({value: currGemstoneBlueprint.name, disabled: true}),
      weight: new FormControl(this.currGemForm.get('currGemWeight').value),
      count: new FormControl(this.currGemForm.get('currGemCount').value),
      polished: new FormControl(this.currGemForm.get('currGemPolished').value),
    }));

    this.currGemForm.reset();
  }

  removeGemStone(index: number) {
    this.gemStones.removeAt(index);
  }

  getGemStones() {
    return this.gemStones.controls;
  }

  addGemstoneBlueprint() {
    this.modalService.open(GemstoneBlueprintFormComponent);
  }

  filterGemstoneBlueprints() {
    const currColor = this.currGemForm.get('currGemColor').value;
    this.currGemForm.get('currGemStone').reset();
    if (currColor === '') {
      this.filteredGemstones = this.unfilteredGemstones;
    } else {
      this.filteredGemstones = this.unfilteredGemstones.filter((gemStoneBlueprint: GemstoneBlueprintModel) => gemStoneBlueprint.color === currColor);
    }
  }
}
