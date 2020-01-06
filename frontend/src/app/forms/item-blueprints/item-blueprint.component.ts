import {Component, Input, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-item-blueprint',
  templateUrl: './item-blueprint.component.html',
  styleUrls: ['./item-blueprint.component.css']
})
export class ItemBlueprintComponent implements OnInit {
  editMode = false;
  activeForm: string;

  @Input() parentForm: FormGroup;

  // Frontend display options
  itemTypes = ['WEAPON', 'ARMOR', 'TREASURE', 'GOODS'];


  constructor(private router: Router) { }

  ngOnInit() {
  }

  activateForm(itemType: string) {
    this.activeForm = itemType;
    this.router.navigate(['inputs', 'item', itemType.toLowerCase()]);
  }

  onSubmit() {

  }
}
