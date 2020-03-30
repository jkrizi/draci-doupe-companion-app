import {Component, OnDestroy, OnInit} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {EnumsService} from '../../../../../../services/enums.service';
import {GemstoneBlueprintService} from '../../../../../../services/gemstone-blueprint.service';
import {v4 as uuid} from 'uuid';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-gemstone-blueprint-form',
  templateUrl: './gemstone-blueprint-form.component.html',
  styleUrls: ['./gemstone-blueprint-form.component.css']
})
export class GemstoneBlueprintFormComponent implements OnInit, OnDestroy {
  gemstoneBlueprintForm: FormGroup;
  colors: string[];
  private colorSubscription: Subscription;

  constructor(
    public activeModal: NgbActiveModal,
    private enumsService: EnumsService,
    private gemstoneBlueprintService: GemstoneBlueprintService
  ) { }

  ngOnInit(): void {
    this.gemstoneBlueprintForm =  new FormGroup({
      id: new FormControl(''),
      name: new FormControl('', Validators.required),
      color: new FormControl('', Validators.required),
      unitPrice: new FormControl('', Validators.required)
    });

    this.colorSubscription = this.enumsService.getColors().subscribe((colors: string[]) => {
      this.colors = colors;
      this.colors.splice(0, 0, '');
    });
  }

  ngOnDestroy(): void {
    this.colorSubscription.unsubscribe();
  }

  onSubmit(): void {
  }

  save(): void {
    this.gemstoneBlueprintForm.patchValue({id: uuid()});
    this.gemstoneBlueprintService.save(this.gemstoneBlueprintForm.value);
    this.close();
  }

  close(): void {
    this.activeModal.close('Close click');
  }
}
